from sys import stdin, maxsize
from heapq import heappush, heappop

input = stdin.readline
INF = maxsize

n, m = map(int, input().split())  # n: 정점의 수, m: 간선의 수

vertex = [[] for _ in range(n + 1)]

for _ in range(m):
    u, v, w = map(int, input().split())  # u -> v:가중치 w 단방향
    vertex[u].append((v, w))

x, y, z = map(int, input().split())  # x -> y -> z 여부


# Y를 거쳐가는 최단 경로 구하는 함수
def viaY(s, e):
    dist = [INF] * (n + 1)
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


# Y를 거치지 않는 최단 경로 구하는 함수
def n_viaY(s, e):
    dist = [INF] * (n + 1)
    dist[s] = 0
    pq = [(0, s)]

    while pq:
        min_dist, cur_v = heappop(pq)

        if dist[cur_v] != min_dist:
            continue

        for nxt_v, nxt_dist in vertex[cur_v]:
            # 정점 y를 거치지 않는다.
            if nxt_v == y:
                continue
            new_dist = dist[cur_v] + nxt_dist

            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

    return dist[e]


d_1 = viaY(x, y)
d_2 = viaY(y, z)
a_1 = d_1 + d_2
# x -> y로 못 가거나, y -> z로 못 가는 경우
if d_1 == INF or d_2 == INF:
    a_1 = -1

a_2 = n_viaY(x, z)
# y를 거치지 않고, z로 못 가는 경우
if a_2 == INF:
    a_2 = -1

print(f"{a_1} {a_2}")
