from sys import stdin
from collections import deque

input = stdin.readline


def bfs():
    canVisit = [[-1] * m for _ in range(n)]
    canVisit[0][0] = 1

    dq = deque([(0, 0, 1)])
    dys, dxs = [0, 0, -1, 1], [-1, 1, 0, 0]
    while dq:
        cur_y, cur_x, cnt = dq.popleft()

        for dy, dx in zip(dys, dxs):
            nxt_y, nxt_x = cur_y + dy, cur_x + dx
            # 범위를 넘지 않고, 방문 가능하며, MAP 값이 1인 경우 -> append
            if 0 <= nxt_y < n and 0 <= nxt_x < m and canVisit[nxt_y][nxt_x] == -1 and MAP[nxt_y][nxt_x] == 1:
                dq.append((nxt_y, nxt_x, cnt + 1))
                MAP[nxt_y][nxt_x] = cnt + 1

    return MAP[n - 1][m - 1]


n, m = map(int, input().split())
MAP = [list(map(int, input().rstrip())) for _ in range(n)]

print(bfs())
