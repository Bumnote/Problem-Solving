from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def dijkstra(start):
    INF = int(1e9)
    dist = [INF for _ in range(n + 1)]
    dist[start] = 0
    pq = [(0, start)]

    while pq:
        min_dist, cur_v = heappop(pq)

        if min_dist != dist[cur_v]:
            continue

        for nxt_v, nxt_dist in vertex[cur_v]:
            new_dist = dist[cur_v] + nxt_dist
            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist  # 거리 갱신
                heappush(pq, (new_dist, nxt_v))

    idx, MAX = 0, 0
    for i in range(1, n + 1):
        # 현재 위치에서 가장 거리가 먼 정점과 거리를 저장
        if MAX < dist[i]:
            idx, MAX = i, dist[i]  # 정보 갱신

    return idx, MAX


n = int(input().rstrip())  # n: 노드의 개수

vertex = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    p, c, w = map(int, input().split())
    vertex[p].append((c, w))
    vertex[c].append((p, w))

root = 1
# 트리의 지름
# 1. 우선 루트 정점에서 제일 먼 정점을 선택
node, _ = dijkstra(root)

# 2. 선택한 정점에서 다시 가장 먼 정점까지의 거리가 트리의 지름
_, d = dijkstra(node)

print(d if d != int(1e9) else 0)
