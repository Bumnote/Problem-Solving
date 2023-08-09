from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

n, m = map(int, input().split())  # n: 정점의 수, m: 간선의 수
INF = float('inf')
vertex = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())  # a <-> b: 가중치 c
    vertex[a].append((b, c))
    vertex[b].append((a, c))

s, t = map(int, input().split())  # s -> t
dist = [INF] * (n + 1)
dist[s] = 0
pq = [(0, s)]

while pq:
    min_dist, cur_v = heappop(pq)

    if dist[cur_v] != min_dist:
        continue

    for nxt_v, nxt_dist in vertex[cur_v]:
        new_dist = dist[cur_v] + nxt_dist

        if new_dist < dist[nxt_v]:
            dist[nxt_v] = new_dist
            heappush(pq, (new_dist, nxt_v))

print(dist[t])
