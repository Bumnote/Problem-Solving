from sys import stdin, maxsize
from heapq import heappush, heappop

input = stdin.readline

INF = maxsize
# 정점의 개수가 너무 크므로, 플로이드 워셜보다는 다익스트라 구현
N = int(input().strip())  # N: 땅의 개수 (1 <= N <= 100_000)
live = set(map(int, input().split()))  # 친구 A, B, C 의 위치

house = [[] for _ in range(N + 1)]
M = int(input().strip())  # M: 도로의 개수
for _ in range(M):
    D, E, L = map(int, input().split())  # D <-> E: 가중치 L 양방향
    house[D].append((E, L))
    house[E].append((D, L))

# A, B, C 로부터 모든 집까지 탐색 -> 즉, 다익스트라 3번
h_dist = [INF] * (N + 1)
# 다익스트라 알고리즘
for i in live:
    dist = [INF] * (N + 1)
    dist[i] = 0
    pq = [(0, i)]

    while pq:
        min_dist, cur_v = heappop(pq)
        # A, B, C 로부터 집 i까지의 최단 거리만을 담는다.
        h_dist[cur_v] = min(min_dist, h_dist[cur_v])
        if dist[cur_v] != min_dist:
            continue

        for nxt_v, nxt_dist in house[cur_v]:
            new_dist = dist[cur_v] + nxt_dist
            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

# A, B, C 로부터 최단 거리 중 가장 멀리 있는 곳의 집이 정답.
ans = h_dist.index(max(h_dist[1:]))
print(ans)
