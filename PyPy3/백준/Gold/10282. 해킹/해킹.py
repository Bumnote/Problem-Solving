from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def dijkstra(node):
    INF = float('inf')
    dist = [INF for _ in range(n + 1)]
    dist[node] = 0
    pq = [(0, node)]

    while pq:
        min_dist, cur_v = heappop(pq)

        if min_dist != dist[cur_v]:
            continue

        for nxt_v, nxt_dist in vertex[cur_v]:
            new_dist = min_dist + nxt_dist
            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

    cnt, time = 0, 0
    for d in dist[1:]:
        if d != INF:
            cnt += 1
            time = max(time, d)

    return (cnt, time)


t = int(input().rstrip())

for _ in range(t):
    n, d, c = map(int, input().split())

    vertex = [[] for _ in range(n + 1)]

    for _ in range(d):
        a, b, s = map(int, input().split())  # b -> a : s초
        vertex[b].append((a, s))

    cnt, time = dijkstra(c)
    print(f"{cnt} {time}")
