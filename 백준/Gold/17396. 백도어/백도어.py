from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

INF = float('inf')
N, M = map(int, input().split())  # N: 분기점의 수, M: 길의 수
sight = list(map(int, input().split()))  # 0: 안 보인다. / 1: 보인다.
vertex = [[] for _ in range(N + 1)]
dist = [INF] * (N + 1)
dist[0] = 0
pq = [(0, 0)]

for _ in range(M):
    a, b, t = map(int, input().split())  # a <-> b: 시간 t
    # 넥서스가 아닌데, 시야에 보인다면 -> 탐색하지 않는다.
    if (a != N - 1 and b != N - 1) and (sight[a] == 1 or sight[b] == 1):
        continue
    vertex[a].append((b, t))
    vertex[b].append((a, t))

# 다익스트라 알고리즘 구현
while pq:
    min_dist, cur_v = heappop(pq)

    # 현재노드까지의 최단 거리 정보와 일치하지 않는다면 -> continue
    # 힙 구조 상 최솟값만 뽑히기 때문에, 과거의 정보가 남아있을 수 있기 때문이다.
    if dist[cur_v] != min_dist:
        continue

    # 현재 노드에서 갈 수 있는 다음 노드들을 검사
    for nxt_v, nxt_dist in vertex[cur_v]:
        # 최단 거리로 온 현재 노드에서 다음 노드로 가는 거리
        new_dist = dist[cur_v] + nxt_dist

        # 다음 노드까지 최단 거리가 기존 정보보다 더 짧다면 -> 갱신
        if new_dist < dist[nxt_v]:
            dist[nxt_v] = new_dist
            heappush(pq, (new_dist, nxt_v))

print(dist[N - 1] if dist[N - 1] != INF else -1)
