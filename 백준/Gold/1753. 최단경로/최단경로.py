from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

INF = float('inf')

v, e = map(int, input().split())  # v: 정점의 개수, e: 간선의 개수
k = int(input().strip())  # k: 시작 정점
vertex = [{} for _ in range(v + 1)]

for _ in range(e):
    # 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있다.
    # 즉, 두 간선 사이의 최솟값으로 주어지는 거리를 저장해야한다.
    v1, v2, w = map(int, input().split())  # v1 -> v2: 가중치 w
    if v2 not in vertex[v1]:
        vertex[v1][v2] = w
    else:
        # u 정점에서 v로 가는 간선이 이미 존재한다면, 새로 주어진 거리와
        # 비교하여 더 작은 거리를 vertex[u][v]로 갱신한다.
        vertex[v1][v2] = min(vertex[v1][v2], w)

dist = [INF] * (v + 1)
dist[k] = 0  # 시작 정점 0으로 초기화
pq = [(0, k)]  # (현재 노드까지의 최단 거리, 정점) 초기화

while pq:
    min_dist, cur_v = heappop(pq)  # 거리 기준 최솟값 pop

    # 현 정점까지의 가장 최단 거리(dist[cur_v])가 pop된 거리 정보와 다르다면
    # 같은 정점에 대한 정보가 최신화가 안 되어있는 정보이기 때문에 continue
    # heapq는 최솟값만을 pop하기 때문에 이런 문제가 발생할 수 있다.
    if dist[cur_v] != min_dist:
        continue

    for nxt_v, nxt_dist in vertex[cur_v].items():
        new_dist = dist[cur_v] + nxt_dist  # 다음 정점으로 가는 최단 거리 후보

        # 다음 정점까지 갈 때, 최단거리라고 생각했던 정보보다 더 값이 작으면 -> 갱신
        if new_dist < dist[nxt_v]:
            dist[nxt_v] = new_dist  # 거리 정보 갱신
            heappush(pq, (new_dist, nxt_v))

for elem in dist[1:]:
    if elem == INF:
        print("INF")
    else:
        print(elem)
