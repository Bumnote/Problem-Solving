from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def dijkstra(s, e):
    INF = float('inf')
    cost = [[INF for _ in range(k + 1)] for _ in range(n + 1)]
    cost[s][0] = 0

    pq = [(0, s, 0)]

    while pq:
        min_dist, cur_v, cnt = heappop(pq)
        if min_dist != cost[cur_v][cnt]:
            continue

        for nxt_v, nxt_dist in vertex[cur_v].items():
            # 포장할 수 있는 횟수가 남은 경우 -> 이동 비용 0으로 이동
            if cnt < k:
                # 거리를 갱신할 수 있는 경우 -> 갱신 및 heappush
                if cost[nxt_v][cnt + 1] > min_dist:
                    cost[nxt_v][cnt + 1] = min_dist  # 이동 비용: 0
                    heappush(pq, (min_dist, nxt_v, cnt + 1))

            # 포장하지 않는 경우 -> 거리를 갱신할 수 있으면 갱신 및 heappush
            new_dist = min_dist + nxt_dist
            if new_dist < cost[nxt_v][cnt]:
                cost[nxt_v][cnt] = new_dist
                heappush(pq, (new_dist, nxt_v, cnt))

    return min(cost[e][1:])


n, m, k = map(int, input().split())  # n: 도시의 수, m: 도로의 수, k: 포장할 도로의 수
vertex = [{} for _ in range(n + 1)]

# 서울: 1, 포천: n
for _ in range(m):
    v1, v2, t = map(int, input().split())
    if v2 not in vertex[v1]:
        vertex[v1][v2] = t
        vertex[v2][v1] = t
    # 노드 사이에 여러 개의 도로가 입력된다면 -> 더 적은 시간을 가진 도로로 갱신
    else:
        vertex[v1][v2] = min(vertex[v1][v2], t)
        vertex[v2][v1] = min(vertex[v2][v1], t)

dist = dijkstra(1, n)
print(dist)
