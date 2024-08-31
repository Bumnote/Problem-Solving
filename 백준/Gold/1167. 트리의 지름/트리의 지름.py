from sys import stdin, maxsize
from heapq import heappush, heappop

input = stdin.readline


def dijkstra(start):
    INF = maxsize
    dist = [INF for _ in range(v + 1)]
    dist[start] = 0
    pq = [(0, start)]

    while pq:

        min_dist, cur_v = heappop(pq)

        # 이미 처리된 경우는 continue
        if min_dist != dist[cur_v]:
            continue

        for nxt_v, nxt_dist in vertex[cur_v]:
            new_dist = dist[cur_v] + nxt_dist
            if new_dist < dist[nxt_v]:
                dist[nxt_v] = new_dist
                heappush(pq, (new_dist, nxt_v))

    MAX, idx = 0, 0
    for i in range(1, v + 1):
        if MAX < dist[i]:
            MAX = dist[i]
            idx = i

    return idx, MAX


v = int(input().rstrip())  # v: 정점의 개수

vertex = [[] for _ in range(v + 1)]
for _ in range(1, v + 1):
    info = list(map(int, input().split()))
    i = info[0]
    for j in range(1, len(info) - 1, 2):
        nxt_v, dist = info[j], info[j + 1]  # nxt_v: 연결된 다른 정점, dist: 거리
        vertex[i].append((nxt_v, dist))
        vertex[nxt_v].append((i, dist))

p, _ = dijkstra(1)

_, ans = dijkstra(p)
print(ans)
