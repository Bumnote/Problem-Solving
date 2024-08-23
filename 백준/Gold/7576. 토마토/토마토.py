from sys import stdin
from collections import deque

input = stdin.readline

m, n = map(int, input().split())  # n x m MAP
MAP = []
canVisit = [[True] * m for _ in range(n)]
tomato = deque()
for i in range(n):
    MAP.append(list(map(int, input().split())))
    for j in range(m):
        if MAP[i][j] == -1:
            canVisit[i][j] = False  # 방문 처리
        elif MAP[i][j] == 1:
            tomato.append((i, j, 0))
            canVisit[i][j] = False

cnt = 0
dys, dxs = [0, 0, -1, 1], [-1, 1, 0, 0]
while tomato:

    cur_y, cur_x, cnt = tomato.popleft()

    for dy, dx in zip(dys, dxs):
        nxt_y, nxt_x = cur_y + dy, cur_x + dx
        if 0 <= nxt_y < n and 0 <= nxt_x < m and canVisit[nxt_y][nxt_x] and MAP[nxt_y][nxt_x] == 0:
            canVisit[nxt_y][nxt_x] = False  # 방문 처리
            tomato.append((nxt_y, nxt_x, cnt + 1))

flag = True
for y in range(n):
    for x in range(m):
        if canVisit[y][x]:
            flag = False
            break

print(cnt if flag else -1)
