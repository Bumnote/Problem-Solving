from sys import stdin
from collections import deque

input = stdin.readline


def bfs(y, x, h):
    dq = deque([(y, x)])
    dys, dxs = [-1, 1, 0, 0], [0, 0, -1, 1]
    while dq:
        cur_y, cur_x = dq.popleft()

        for dy, dx in zip(dys, dxs):
            nxt_y, nxt_x = cur_y + dy, cur_x + dx
            if 0 <= nxt_y < n and 0 <= nxt_x < n and not visited[nxt_y][nxt_x] and MAP[nxt_y][nxt_x] > h:
                visited[nxt_y][nxt_x] = True
                dq.append((nxt_y, nxt_x))


n = int(input().rstrip())
MAP = []
height = 0
for i in range(n):
    MAP.append(list(map(int, input().split())))
    for j in range(n):
        height = max(height, MAP[i][j])

area = 1
for h in range(1, height + 1):
    visited = [[False for _ in range(n)] for _ in range(n)]
    cnt = 0
    for y in range(n):
        for x in range(n):
            if not visited[y][x] and MAP[y][x] > h:
                bfs(y, x, h)
                cnt += 1

    area = max(area, cnt)
print(area)
