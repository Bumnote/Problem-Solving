from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def dijkstra():
    INF = float('inf')
    dist = [INF for _ in range(n)]
    dist[0] = 0
    pq = [(0, 0)]

    while pq:

        min_dist, cur_v = heappop(pq)
        if min_dist != dist[cur_v]:
            continue

        for nxt_v, nxt_dist in vertex[cur_v]:
            new_dist = min_dist + nxt_dist
            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

    return dist[n - 1] if dist[n - 1] != INF else -1


n, m = map(int, input().split())

lst = list(map(int, input().split()))

vertex = [[] for _ in range(n)]
for _ in range(m):
    a, b, t = map(int, input().split())  # a <-> b: 양방향 t
    # 시야가 보이는 곳은 탐색하지 않는다.
    if (0 < a < n - 1 and lst[a] == 1) or (0 < b < n - 1 and lst[b] == 1):
        continue
    vertex[a].append((b, t))
    vertex[b].append((a, t))

print(dijkstra())
