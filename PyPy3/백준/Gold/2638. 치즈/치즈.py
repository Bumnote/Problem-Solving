from sys import stdin
from collections import deque

input = stdin.readline


def in_range(y, x):
    return 0 <= y < n and 0 <= x < m


def bfs(y, x):
    dq = deque([(y, x)])
    dys, dxs = [-1, 1, 0, 0], [0, 0, -1, 1]

    visited = [[0 for _ in range(m)] for _ in range(n)]
    visited[y][x] = 1  # 방문 처리
    cheese = deque()
    flag = False
    while dq:

        cur_y, cur_x = dq.popleft()

        for dy, dx in zip(dys, dxs):
            nxt_y, nxt_x = cur_y + dy, cur_x + dx
            if in_range(nxt_y, nxt_x):
                if visited[nxt_y][nxt_x] == 0 and MAP[nxt_y][nxt_x] == 0:
                    dq.append((nxt_y, nxt_x))
                    visited[nxt_y][nxt_x] = 1

                if MAP[nxt_y][nxt_x] == 1:
                    visited[nxt_y][nxt_x] += 1
                    if visited[nxt_y][nxt_x] >= 2:
                        cheese.append((nxt_y, nxt_x))

    if cheese:
        flag = True
        for cy, cx in cheese:
            MAP[cy][cx] = 0

    return 1 if flag else 0


n, m = map(int, input().split())
MAP = [list(map(int, input().split())) for _ in range(n)]

time = 0
while True:
    v = bfs(0, 0)
    if v == 0:
        print(time)
        break

    time += v
