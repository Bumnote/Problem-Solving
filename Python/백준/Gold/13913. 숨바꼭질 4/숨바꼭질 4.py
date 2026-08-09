from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def get_trace(path, e):
    trace = []
    curr = e
    while path[curr] != -1:
        trace.append(curr)
        curr = path[curr]

    trace.append(n)
    return trace[::-1]


def dijkstra():
    INF = float('inf')
    dist = [INF] * (LEN + 1)
    path = [-1 for _ in range(LEN + 1)]
    dist[n] = 0
    pq = [(0, n)]

    while pq:
        min_dist, cur_v = heappop(pq)

        if min_dist != dist[cur_v]:
            continue

        if cur_v == k:
            break

        for nxt_v in [2 * cur_v, cur_v - 1, cur_v + 1]:
            if 0 <= nxt_v <= LEN:
                new_dist = min_dist + 1
                if new_dist < dist[nxt_v]:
                    dist[nxt_v] = new_dist
                    path[nxt_v] = cur_v
                    heappush(pq, (new_dist, nxt_v))

    trace = get_trace(path, k)
    return dist[k], trace


n, k = map(int, input().split())
LEN = 100_000

dist, trace = dijkstra()
print(dist)
print(*trace)
