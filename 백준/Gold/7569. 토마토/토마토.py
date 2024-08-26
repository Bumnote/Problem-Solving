from sys import stdin
from collections import deque

input = stdin.readline


def isTrue(canVisit, day):
    for k in range(h):
        for i in range(n):
            for j in range(m):
                if canVisit[k][i][j]:
                    return -1

    return day


m, n, h = map(int, input().split())  # h * (n x m) MAP

# -1: 토마토가 없는 칸, 0: 익지 않은 토마토, 1: 익은 토마토
MAP = [[list(map(int, input().split())) for _ in range(n)] for _ in range(h)]
canVisit = [[[True] * m for _ in range(n)] for _ in range(h)]
tomato = deque()
for k in range(h):
    for i in range(n):
        for j in range(m):
            # 익은 토마토인 경우
            if MAP[k][i][j] == 1:
                tomato.append((k, i, j, 0))
                canVisit[k][i][j] = False  # 방문 처리
            # 토마토가 없는 칸인 경우
            elif MAP[k][i][j] == -1:
                canVisit[k][i][j] = False  # 방문 처리

day = 0
dhs, dys, dxs = [-1, 1, 0, 0, 0, 0], [0, 0, 0, 0, -1, 1], [0, 0, -1, 1, 0, 0]
while tomato:
    cur_h, cur_y, cur_x, cnt = tomato.popleft()
    day = max(day, cnt)  # 최장 일수를 저장

    for dh, dy, dx in zip(dhs, dys, dxs):
        nxt_h, nxt_y, nxt_x = cur_h + dh, cur_y + dy, cur_x + dx
        # 범위를 넘지 않고, 방문 가능하고, 익지 않은 토마토인 경우
        if 0 <= nxt_h < h and 0 <= nxt_y < n and 0 <= nxt_x < m and canVisit[nxt_h][nxt_y][nxt_x] and MAP[nxt_h][nxt_y][
            nxt_x] == 0:
            tomato.append((nxt_h, nxt_y, nxt_x, cnt + 1))
            canVisit[nxt_h][nxt_y][nxt_x] = False  # 방문 처리

print(isTrue(canVisit, day))
