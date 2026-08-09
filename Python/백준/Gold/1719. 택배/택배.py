from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def get_next_node(path, e):
    trace = []
    curr = e
    next = None

    while curr != -1:
        trace.append(curr)
        curr = path[curr]

    next = trace[-2]
    return next


def dijkstra(s, e):
    INF = float('inf')
    dist = [INF for _ in range(n + 1)]
    dist[s] = 0
    pq = [(0, s)]
    path = [-1 for _ in range(n + 1)]

    while pq:

        min_dist, cur_v = heappop(pq)

        if min_dist != dist[cur_v]:
            continue

        if cur_v == e:
            break

        for nxt_v, nxt_dist in vertex[cur_v]:
            new_dist = min_dist + nxt_dist
            if new_dist < dist[nxt_v]:
                path[nxt_v] = cur_v
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

    next = get_next_node(path, e)
    return next


n, m = map(int, input().split())

vertex = [[] for _ in range(n + 1)]
for _ in range(m):
    v1, v2, cost = map(int, input().split())  # v1 <-> v2: 양방향 cost
    vertex[v1].append((v2, cost))
    vertex[v2].append((v1, cost))

MAP = [["-" for _ in range(n + 1)] for _ in range(n + 1)]

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if i == j:
            print(MAP[i][j], end=" ")
        else:
            MAP[i][j] = dijkstra(i, j)
            print(MAP[i][j], end=" ")
    print()
