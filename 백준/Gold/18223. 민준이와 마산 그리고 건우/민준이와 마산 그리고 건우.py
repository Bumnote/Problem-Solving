from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

INF = float('inf')
V, E, P = map(int, input().split())  # V: 정점의 개수, E: 간선의 개수, P: 건우의 위치
vertex = [[] for _ in range(V + 1)]

for _ in range(E):
    a, b, c = map(int, input().split())  # a <-> b: 가중치 c
    vertex[a].append((b, c))
    vertex[b].append((a, c))


def dijkstra(s, e):
    dist = [INF] * (V + 1)
    dist[s] = 0  # 출발지: 1번 정점 -> 도착지: V번 정점
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


# 마산까지 최단거리와 건우를 거쳐서 마산을 가는 최단거리가 같다면 -> 건우를 구한다.
if dijkstra(1, V) == dijkstra(1, P) + dijkstra(P, V):
    print("SAVE HIM")
# 건우를 구하는 최단거리와 전체 최단거리가 다르다면 -> 건우를 구하지 못한다.
else:
    print("GOOD BYE")
