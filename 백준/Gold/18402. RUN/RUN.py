from sys import stdin, maxsize
from heapq import heappush, heappop

input = stdin.readline
INF = maxsize

n = int(input().strip())  # n: 감방의 수
e = int(input().strip())  # e: 출구 셀의 번호
t = int(input().strip())  # t: 타이머의 시작 값
m = int(input().strip())  # m: 감옥의 연결 수
vertex = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, l = map(int, input().split())  # a -> b: 시간 l 단방향
    vertex[a].append((b, l))


# 다익스트라 구현 함수
def dijkstra(i, j):
    dist = [INF] * (n + 1)
    dist[i] = 0
    pq = [(0, i)]

    while pq:
        min_dist, cur_v = heappop(pq)
        if dist[cur_v] != min_dist:
            continue

        for nxt_v, nxt_dist in vertex[cur_v]:
            new_dist = dist[cur_v] + nxt_dist
            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

    # t초 안에 도달가능하면 -> 탈출 성공
    return True if dist[e] <= t else False


cnt = 0
for p in range(1, n + 1):
    # 시작점에서 탈출 셀까지 도달 가능하다면 -> count
    if dijkstra(p, t):
        cnt += 1

print(cnt)
