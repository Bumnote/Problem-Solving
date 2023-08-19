from sys import stdin, maxsize
from heapq import heappush, heappop

INF = maxsize
input = stdin.readline

n = int(input().strip())  # n: 도시의 개수
m = int(input().strip())  # m: 버스의 개수
vertex = [[] for _ in range(n + 1)]

for _ in range(m):
    s, e, w = map(int, input().split())  # s -> e:요금 w 단방향
    vertex[s].append((e, w))

a, b = map(int, input().split())  # a -> b
dist = [INF] * (n + 1)
dist[a] = 0  # 출발지의 거리를 0을 초기화
pq = [(0, a)]

while pq:
    min_dist, cur_v = heappop(pq)

    if dist[cur_v] != min_dist:
        continue

    for nxt_v, nxt_dist in vertex[cur_v]:
        new_dist = dist[cur_v] + nxt_dist

        if new_dist < dist[nxt_v]:
            dist[nxt_v] = new_dist
            heappush(pq, (new_dist, nxt_v))

print(dist[b])
