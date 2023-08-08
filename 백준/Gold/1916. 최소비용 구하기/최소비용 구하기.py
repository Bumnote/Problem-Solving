from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

INF = float('inf')
N = int(input().strip())  # N: 도시의 개수
M = int(input().strip())  # M: 버스의 개수

vertex = [[] for _ in range(N + 1)]
for _ in range(M):
    s, e, w = map(int, input().split())  # s -> e: 가중치 w
    vertex[s].append((e, w))

a, b = map(int, input().split())  # a -> b: 최소 비용을 구하자.
dist = [INF] * (N + 1)
dist[a] = 0  # 출발지인 a의 비용 0으로 초기화
pq = [(0, a)]

while pq:
    min_dist, cur_v = heappop(pq)  # cur_v까지 가는 거리, 현재 노드

    # 현재 노드로 올 수 있는 최단 거리 정보와 다르다면 -> continue
    if dist[cur_v] != min_dist:
        continue

    for nxt_v, nxt_dist in vertex[cur_v]:
        # 현재 노드와 연결된 다음 노드인 nxt_v까지 가는 거리 계산
        new_dist = dist[cur_v] + nxt_dist

        # 다음 노드까지 더 빠르게 갈 수 있다면 -> 갱신
        if new_dist < dist[nxt_v]:
            dist[nxt_v] = new_dist
            heappush(pq, (new_dist, nxt_v))

print(dist[b])
