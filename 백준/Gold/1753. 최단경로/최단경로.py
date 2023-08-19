from sys import stdin, maxsize
from heapq import heappush, heappop

INF = maxsize
input = stdin.readline

v, e = map(int, input().split())  # v: 정점의 개수, e: 간선의 개수
vertex = [{} for _ in range(v + 1)]

k = int(input().strip())  # k: 시작 정점
for _ in range(e):
    s, t, w = map(int, input().split())  # s -> t:가중치 w 단방향
    # s -> t 가 없는 경우
    if t not in vertex[s]:
        vertex[s][t] = w
        # u -> v 가 이미 존재하는 경우
    else:
        # 새로운 u -> v 의 가중치가 더 짧은 경우 -> 갱신
        if vertex[s][t] > w:
            vertex[s][t] = w

dist = [INF] * (v + 1)
dist[k] = 0
pq = [(0, k)]

while pq:
    min_dist, cur_v = heappop(pq)

    if dist[cur_v] != min_dist:
        continue

    for nxt_v, nxt_dist in vertex[cur_v].items():
        new_dist = dist[cur_v] + nxt_dist
        if new_dist < dist[nxt_v]:
            dist[nxt_v] = new_dist
            heappush(pq, (new_dist, nxt_v))

for elem in dist[1:]:
    # 경로가 존재하지 않는 경우 
    if elem == INF:
        print("INF")
    else:
        print(elem)
