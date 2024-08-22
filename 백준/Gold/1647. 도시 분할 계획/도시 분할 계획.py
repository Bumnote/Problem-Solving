from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

n, m = map(int, input().split())

# 간선의 수가 훨씬 많으므로, 프림 알고리즘 활용
vertex = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    vertex[a].append((b, c))
    vertex[b].append((a, c))

canVisit = [True for _ in range(n + 1)]
pq = [(0, 1)]  # 시작 정점을 1번으로 설정
total = 0
cnt = 0
MAX = 0
while pq:
    cost, cur_v = heappop(pq)  # 비용, 현재 정점

    # 이미 방문했던 정점은 탐색하지 않는다.
    if not canVisit[cur_v]:
        continue

    MAX = max(MAX, cost)
    cnt += 1
    total += cost
    canVisit[cur_v] = False  # 방문 처리

    # 마을의 개수만큼 탐색했으면 -> 탐색 중지
    if cnt == n:
        break

    for nxt_v, nxt_cost in vertex[cur_v]:
        heappush(pq, (nxt_cost, nxt_v))

print(total - MAX)
