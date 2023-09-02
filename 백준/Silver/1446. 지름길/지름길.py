from sys import stdin, maxsize
from heapq import heappush, heappop

input = stdin.readline
INF = maxsize

n, d = map(int, input().split())  # n: 지름길의 개수, d: 도로의 길이
vertex = [[] for _ in range(d + 1)]
for i in range(d):
    vertex[i].append((i + 1, 1))

for _ in range(n):
    s, e, l = map(int, input().split())  # s -> d: 길이 l 단방향
    # 고속도로의 길이를 넘는 경우 -> 고려하지 않는다.
    if s < 0 or s > d or e < 0 or e > d:
        continue

    vertex[s].append((e, l))

dist = [INF] * (d + 1)
dist[0] = 0
pq = [(0, 0)]

while pq:
    min_dist, cur_v = heappop(pq)

    if dist[cur_v] != min_dist:
        continue

    for nxt_v, nxt_dist in vertex[cur_v]:
        new_dist = dist[cur_v] + nxt_dist
        if new_dist < dist[nxt_v]:
            dist[nxt_v] = new_dist
            heappush(pq, (new_dist, nxt_v))

print(dist[d])
