from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def dijkstra():
    INF = float('inf')
    dist = [INF for _ in range(n + 1)]
    dist[x] = 0
    pq = [(0, x)]

    info = []
    while pq:
        min_dist, cur_v = heappop(pq)

        if min_dist != dist[cur_v]:
            continue

        if dist[cur_v] == k:
            info.append(cur_v)

        for nxt_v in vertex[cur_v]:
            new_dist = min_dist + 1
            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

    return sorted(info) if info else [-1]


n, m, k, x = map(int, input().split())

vertex = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())  # a -> b 단방향
    vertex[a].append(b)

cities = dijkstra()
print(*cities, sep="\n")
