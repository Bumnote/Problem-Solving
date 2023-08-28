from sys import stdin, maxsize
from heapq import heappush, heappop

input = stdin.readline
INF = maxsize

# c: 도로의 개수, p: 목초지의 개수, pb: 출발지, pa_1, pa_2: 목표 지점
c, p, pb, pa_1, pa_2 = map(int, input().split())
vertex = [[] for _ in range(p + 1)]

for _ in range(c):
    p1_i, p2_i, d_i = map(int, input().split())  # p1_i <-> p2_i: 거리 d_i 양방향
    vertex[p1_i].append((p2_i, d_i))
    vertex[p2_i].append((p1_i, d_i))


def dijkstra(s, e):
    dist = [INF] * (p + 1)
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

    # 시작 정점 s에서부터 도착 정점 e까지의 최단거리를 반환
    return dist[e]


# pb -> pa_1 -> pa_2 인 경우
case_1 = dijkstra(pb, pa_1) + dijkstra(pa_1, pa_2)

# pb -> pa_2 -> pa_1 인 경우
case_2 = dijkstra(pb, pa_2) + dijkstra(pa_2, pa_1)

print(min(case_1, case_2))
