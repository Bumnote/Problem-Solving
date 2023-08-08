from sys import stdin
from heapq import heappush, heappop

input = stdin.readline
INF = float('inf')


# s -> e로 가는 최단 거리를 구하는 다익스트라 알고리즘
def dijkstra(s, e):
    dist = [INF] * (N + 1)
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

    return dist[e]


N, E = map(int, input().split())  # N: 정점의 개수, E: 간선의 개수
vertex = [[] for _ in range(N + 1)]

for _ in range(E):
    a, b, c = map(int, input().split())  # a <-> b: 가중치 c
    vertex[a].append((b, c))
    vertex[b].append((a, c))

# 1 -> u -> v -> N or 1 -> v -> u -> N 
u, v = map(int, input().split())

d_1 = dijkstra(1, u) + dijkstra(u, v) + dijkstra(v, N)
d_2 = dijkstra(1, v) + dijkstra(v, u) + dijkstra(u, N)

if d_1 >= INF and d_2 >= INF:
    print(-1)
else:
    print(min(d_1, d_2))
