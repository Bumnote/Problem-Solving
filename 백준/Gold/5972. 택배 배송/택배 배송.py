from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

INF = float('inf')
N, M = map(int, input().split())  # N: 헛간의 개수, M: 길의 개수
vertex = [[] for _ in range(N + 1)]
dist = [INF] * (N + 1)
dist[1] = 0
pq = [(0, 1)]

for _ in range(M):
    a_i, b_i, c_i = map(int, input().split())  # a_i <-> b_i: c_i 마리의 소
    vertex[a_i].append((b_i, c_i))
    vertex[b_i].append((a_i, c_i))

# 현서: 1 -> 찬홍: N
while pq:
    min_dist, cur_v = heappop(pq)

    if dist[cur_v] != min_dist:
        continue

    for nxt_v, nxt_dist in vertex[cur_v]:
        new_dist = dist[cur_v] + nxt_dist

        if new_dist < dist[nxt_v]:
            dist[nxt_v] = new_dist
            heappush(pq, (new_dist, nxt_v))

print(dist[N])
