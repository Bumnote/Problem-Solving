from sys import stdin
from collections import deque

input = stdin.readline


def bfs(y, x):
    dq = deque([(y, x)])
    dys, dxs = [1, 0, -1, -1, -1, 0, 1, 1], [1, 1, 1, 0, -1, -1, -1, 0]
    while dq:
        cur_y, cur_x = dq.popleft()

        for dy, dx in zip(dys, dxs):
            nxt_y, nxt_x = cur_y + dy, cur_x + dx
            if 0 <= nxt_y < h and 0 <= nxt_x < w and not visited[nxt_y][nxt_x] and MAP[nxt_y][nxt_x] == 1:
                visited[nxt_y][nxt_x] = True
                dq.append((nxt_y, nxt_x))


while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break

    MAP = [list(map(int, input().split())) for _ in range(h)]
    visited = [[False for _ in range(w)] for _ in range(h)]

    cnt = 0
    for y in range(h):
        for x in range(w):
            if not visited[y][x] and MAP[y][x] == 1:
                visited[y][x] = True
                cnt += 1
                bfs(y, x)

    print(cnt)
