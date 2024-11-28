from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def in_range(y, x):
    return 0 <= y < n and 0 <= x < m


def dijkstra():
    INF = float('inf')
    dist = [[INF for _ in range(m)] for _ in range(n)]
    dist[0][0] = 1

    pq = [(0, 1, 0, 0)]
    dys, dxs = [-1, 1, 0, 0], [0, 0, -1, 1]
    while pq:
        block, min_dist, cur_y, cur_x = heappop(pq)

        if min_dist != dist[cur_y][cur_x]:
            continue

        for dy, dx in zip(dys, dxs):
            nxt_y, nxt_x = cur_y + dy, cur_x + dx
            if in_range(nxt_y, nxt_x):
                if MAP[nxt_y][nxt_x] == 0:
                    if min_dist + 1 < dist[nxt_y][nxt_x]:
                        dist[nxt_y][nxt_x] = min_dist + 1
                        heappush(pq, (block, min_dist + 1, nxt_y, nxt_x))
                else:
                    if block == 0 and min_dist + 1 < dist[nxt_y][nxt_x]:
                        dist[nxt_y][nxt_x] = min_dist + 1
                        heappush(pq, (block + 1, min_dist + 1, nxt_y, nxt_x))

    return dist[n - 1][m - 1] if dist[n - 1][m - 1] != INF else -1


n, m = map(int, input().split())

# (1, 1) -> (n, m) / 0: 이동 가능, 1: 벽
MAP = [list(map(int, input().rstrip())) for _ in range(n)]
print(dijkstra())
