from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def dijkstra(start, end):
    INF = int(1e9)
    dist = [INF] * (n + 1)
    dist[start] = 0
    pq = [(0, start)]

    while pq:
        min_dist, cur_v = heappop(pq)
        if min_dist != dist[cur_v]:
            continue

        for nxt_v, nxt_dist in vertex[cur_v]:
            new_dist = dist[cur_v] + nxt_dist
            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

    return dist[end]


# 플로이드 워셜 -> O(N^3) 시간초과
n, m, x = map(int, input().split())  # n: 학생 수, m: 단방향 도로의 수, x: 파티 장소

vertex = [[] for _ in range(n + 1)]
for _ in range(m):
    s, e, t = map(int, input().split())  # s -> e: 가중치 t
    vertex[s].append((e, t))  # 단방향 그래프

max_dist = 0
for i in range(1, n + 1):
    # 파티 장소에 사는 사람은 제외
    if i == x:
        continue
    max_dist = max(max_dist, dijkstra(i, x) + dijkstra(x, i))

print(max_dist)
