from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def dijkstra(s, x):
    INF = 1e9
    dist = [INF for _ in range(n + 1)]
    path = [-1 for _ in range(n + 1)]

    dist[s] = 0
    pq = [(0, s)]

    while pq:
        min_dist, cur_v = heappop(pq)
        if min_dist != dist[cur_v]:
            continue

        for nxt_v, nxt_dist in vertex[cur_v]:
            new_dist = min_dist + nxt_dist
            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                path[nxt_v] = cur_v
                heappush(pq, (new_dist, nxt_v))

    return dist[x]


T = int(input().rstrip())

for _ in range(T):
    n, m, t = map(int, input().split())
    s, g, h = map(int, input().split())

    dist_g_h = None
    vertex = [[] for _ in range(n + 1)]
    for _ in range(m):
        a, b, d = map(int, input().split())  # a <-> b: 양방향 d
        vertex[a].append((b, d))
        vertex[b].append((a, d))
        if (a == g and b == h) or (a == h and b == g):
            dist_g_h = d

    dist_s_h = dijkstra(s, g) + dist_g_h
    dist_s_g = dijkstra(s, h) + dist_g_h
    ans = []
    for _ in range(t):
        x = int(input().rstrip())
        dist_s_x = dijkstra(s, x)
        dist_s_g_h_x = dist_s_h + dijkstra(h, x)
        dist_s_h_g_x = dist_s_g + dijkstra(g, x)

        if dist_s_x == dist_s_h_g_x or dist_s_x == dist_s_g_h_x:
            ans.append(x)

    print(*sorted(ans))
