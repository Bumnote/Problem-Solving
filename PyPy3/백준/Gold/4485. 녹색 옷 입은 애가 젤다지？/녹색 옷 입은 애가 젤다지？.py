from sys import stdin
from heapq import heappush, heappop

input = stdin.readline


def dijkstra():
    INF = float('inf')
    dist = [[INF for _ in range(n)] for _ in range(n)]
    dist[0][0] = MAP[0][0]
    pq = [(MAP[0][0], 0, 0)]

    dys, dxs = [-1, 1, 0, 0], [0, 0, -1, 1]
    while pq:
        min_dist, cur_y, cur_x = heappop(pq)

        if min_dist != dist[cur_y][cur_x]:
            continue

        for dy, dx in zip(dys, dxs):
            nxt_y, nxt_x = cur_y + dy, cur_x + dx
            if 0 <= nxt_y < n and 0 <= nxt_x < n:
                new_dist = min_dist + MAP[nxt_y][nxt_x]
                if new_dist < dist[nxt_y][nxt_x]:
                    dist[nxt_y][nxt_x] = new_dist
                    heappush(pq, (new_dist, nxt_y, nxt_x))

    return dist[n - 1][n - 1]


tc = 1
while True:
    n = int(input().rstrip())
    if n == 0:
        break

    MAP = [list(map(int, input().split())) for _ in range(n)]

    ans = dijkstra()

    print(f"Problem {tc}: {ans}")
    tc += 1
