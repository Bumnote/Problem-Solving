from sys import stdin, maxsize
from heapq import heappush, heappop

INF = maxsize
input = stdin.readline

# n: 집의 개수, m: 도로의 개수, x: 거리의 최댓갓, y: 성현이 집
n, m, x, y = map(int, input().split())
vertex = [[] for _ in range(n)]

for _ in range(m):
    a, b, c = map(int, input().split())  # a <-> b: 거리 c 양방향
    vertex[a].append((b, c))
    vertex[b].append((a, c))

dist = [INF] * n
dist[y] = 0
pq = [(0, y)]

while pq:
    min_dist, cur_v = heappop(pq)

    if dist[cur_v] != min_dist:
        continue

    for nxt_v, nxt_dist in vertex[cur_v]:
        new_dist = dist[cur_v] + nxt_dist
        if new_dist < dist[nxt_v]:
            dist[nxt_v] = new_dist
            heappush(pq, (new_dist, nxt_v))

ans = 1
dist[y] = INF  # 성현이의 집을 최단 거리에서 제외
total = 0
while True:
    min_dist = INF
    target = 0
    # 가장 거리가 짧은 정점의 위치와 거리를 구한다.
    for i, e in enumerate(dist):
        if min_dist > e:
            min_dist = e
            target = i

    # 떡을 모두 돌린 경우
    if min_dist == INF:
        break

    # 떡을 돌리기 위해서 방문할 수 없는 경우
    if min_dist * 2 > x:
        ans = -1
        break

    # 왕복할 수 있는 거리가 부족하다면 -> 다음 날에 이동
    if total + min_dist * 2 > x:
        ans += 1
        total = min_dist * 2
        dist[target] = INF
    # 왕복 가능한 경우
    else:
        total += min_dist * 2
        dist[target] = INF

print(ans)
