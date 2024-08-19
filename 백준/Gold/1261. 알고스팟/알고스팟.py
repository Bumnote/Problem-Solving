from sys import stdin
from collections import deque

input = stdin.readline

m, n = map(int, input().split())  # n x m MAP
MAP = [list(map(int, input().strip())) for _ in range(n)]

INF = int(1e9)
dist = [[INF] * m for _ in range(n)]
dist[0][0] = 0  # 출발점 초기화

dq = deque([(0, 0)])
dys, dxs = [0, 0, -1, 1], [-1, 1, 0, 0]
# 0-1 BFS
while dq:
    cur_y, cur_x = dq.popleft()

    if cur_y == n - 1 and cur_x == m - 1:
        print(dist[n - 1][m - 1])
        break

    for dy, dx in zip(dys, dxs):
        nxt_y, nxt_x = cur_y + dy, cur_x + dx
        # 범위를 넘지 않는 경우에만 탐색
        if 0 <= nxt_y < n and 0 <= nxt_x < m:
            # 가중치가 1인 경우 -> 거리 갱신이 가능하다면 오른쪽에 append
            if MAP[nxt_y][nxt_x] == 1:
                if dist[cur_y][cur_x] + 1 < dist[nxt_y][nxt_x]:
                    dist[nxt_y][nxt_x] = dist[cur_y][cur_x] + 1
                    dq.append((nxt_y, nxt_x))
            # 가중치가 0인 경우 -> 거리 갱신이 가능하다면 왼쪽에 append
            else:
                if dist[cur_y][cur_x] < dist[nxt_y][nxt_x]:
                    dist[nxt_y][nxt_x] = dist[cur_y][cur_x]
                    dq.appendleft((nxt_y, nxt_x))
