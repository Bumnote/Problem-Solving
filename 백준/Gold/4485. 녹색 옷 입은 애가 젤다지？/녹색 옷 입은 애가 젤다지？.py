from sys import stdin, maxsize
from heapq import heappush, heappop

input = stdin.readline
INF = maxsize
cnt = 1
while True:
    n = int(input().strip())  # n x n MAP
    if n == 0:
        break

    MAP = [list(map(int, input().split())) for _ in range(n)]
    # 일정한 가중치가 아닌 최단 경로 -> 다익스트라 알고리즘 구현
    dist = [[INF] * n for _ in range(n)]
    dist[0][0] = MAP[0][0]
    pq = [(MAP[0][0], 0, 0)]  # (거리, y위치, x위치)

    while pq:
        min_dist, cur_y, cur_x = heappop(pq)
        if dist[cur_y][cur_x] != min_dist:
            continue

        for dy, dx in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            new_y, new_x = cur_y + dy, cur_x + dx
            # 범위를 넘는다면 -> continue
            if new_y < 0 or new_y >= n or new_x < 0 or new_x >= n:
                continue

            new_dist = dist[cur_y][cur_x] + MAP[new_y][new_x]
            if new_dist < dist[new_y][new_x]:
                dist[new_y][new_x] = new_dist
                heappush(pq, (new_dist, new_y, new_x))

    print(f"Problem {cnt}: {dist[n - 1][n - 1]}")
    cnt += 1
