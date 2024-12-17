from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def dijkstra():
    INF = float('inf')
    dist = [INF for _ in range(d + 1)]
    dist[0] = 0

    pq = [(0, 0)]
    while pq:

        min_dist, cur_v = heappop(pq)

        if min_dist != dist[cur_v]:
            continue

        # 지름길이 있는 경우
        if vertex[cur_v]:
            for nxt_v, nxt_dist in vertex[cur_v]:
                # 범위를 넘지 않는다면 -> 탐색
                if 0 <= nxt_v <= d:
                    new_dist = min_dist + nxt_dist
                    if new_dist < dist[nxt_v]:
                        dist[nxt_v] = new_dist
                        heappush(pq, (new_dist, nxt_v))

        nxt_v = cur_v + 1
        # 범위를 넘지 않는다면 -> 탐색
        if 0 <= nxt_v <= d:
            new_dist = min_dist + 1
            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

    return dist[d]


n, d = map(int, input().split())

vertex = [[] for _ in range(d + 1)]
for _ in range(n):
    s, e, l = map(int, input().split())
    if 0 <= s <= d:
        vertex[s].append((e, l))

print(dijkstra())
