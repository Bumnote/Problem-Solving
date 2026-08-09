from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def dijkstra():
    INF = float('inf')
    dist = [INF for _ in range(n + 1)]
    dist[1] = 0
    pq = [(0, 1)]

    while pq:
        min_dist, cur_v = heappop(pq)

        if min_dist != dist[cur_v]:
            continue

        for nxt_v, nxt_dist in vertex[cur_v]:
            new_dist = min_dist + nxt_dist
            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

    return dist[n]


n, m = map(int, input().split())

vertex = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    vertex[a].append((b, c))
    vertex[b].append((a, c))

print(dijkstra())
