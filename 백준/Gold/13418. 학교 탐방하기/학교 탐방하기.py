from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def prim(pq, total, cnt, flag):
    canVisit = [True for _ in range(n + 1)]
    canVisit[0] = False  # 입구는 방문 처리

    while pq:
        # 오르막길의 개수를 가장 높게 선택하는 경우
        if flag == "ASC":
            cost, cur_v = heappop(pq)
        # 오르막길의 개수를 가장 낮게 선택하는 경우
        else:
            cost, cur_v = heappop(pq)
            cost = -cost

        # 이미 방문한 곳이라면 -> 탐색하지 않는다.
        if not canVisit[cur_v]:
            continue

        cnt += 1  # 방문한 노드의 개수 증가
        # 오르막길이라면 -> 오르막길 비용 증가
        if cost == 0:
            total += 1
        canVisit[cur_v] = False  # 현재 노드 방문 처리

        if cnt == n + 1:
            break

        for nxt_v, nxt_cost in vertex[cur_v]:
            if flag == "ASC":
                heappush(pq, (nxt_cost, nxt_v))
            else:
                heappush(pq, (-nxt_cost, nxt_v))

    return total  # 오르막길의 개수 반환


# 도로의 개수가 적으므로, 프림 알고리즘 구현
n, m = map(int, input().split())

vertex = [[] for _ in range(n + 1)]
total = 0  # 오르막길의 개수
dist = 0
for _ in range(m + 1):
    a, b, c = map(int, input().split())  # a <-> b: 높낮이 여부 c
    if a == 0 or b == 0:
        dist = c
    vertex[a].append((b, c))
    vertex[b].append((a, c))

asc = prim([(dist, 1)], 0, 1, "ASC")
desc = prim([(-dist, 1)], 0, 1, "DESC")

print(asc ** 2 - desc ** 2)
