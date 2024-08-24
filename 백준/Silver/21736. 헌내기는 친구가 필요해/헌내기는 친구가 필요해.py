from sys import stdin
from collections import deque

input = stdin.readline

n, m = map(int, input().split())  # n x m MAP
MAP = []  # O: 빈 공간, X: 벽, I: 도연, P: 사람
canVisit = [[True] * m for _ in range(n)]

iy, ix = None, None
for i in range(n):
    MAP.append(list(input().rstrip()))
    for j in range(m):
        if MAP[i][j] == "I":
            iy, ix = i, j
            canVisit[iy][ix] = False  # 방문 처리

dq = deque([(iy, ix, 0)])
dys, dxs = [0, 0, -1, 1], [-1, 1, 0, 0]
person = 0
while dq:
    cur_y, cur_x, cnt = dq.popleft()
    if MAP[cur_y][cur_x] == "P":
        person += 1

    for dy, dx in zip(dys, dxs):
        nxt_y, nxt_x = cur_y + dy, cur_x + dx
        if 0 <= nxt_y < n and 0 <= nxt_x < m and canVisit[nxt_y][nxt_x] and MAP[nxt_y][nxt_x] != "X":
            canVisit[nxt_y][nxt_x] = False  # 방문 처리
            dq.append((nxt_y, nxt_x, cnt + 1))

print(person if person != 0 else "TT")
