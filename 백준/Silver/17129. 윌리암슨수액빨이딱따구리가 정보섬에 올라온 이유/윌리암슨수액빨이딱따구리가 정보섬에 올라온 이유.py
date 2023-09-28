from sys import stdin
from collections import deque

input = stdin.readline


def bfs(y, x):
    visited = [[True] * m for _ in range(n)]
    visited[y][x] = False  # 시작 위치 방문 처리
    dq = deque()
    dq.append((y, x, 0))

    while dq:
        cur_y, cur_x, cur_cnt = dq.popleft()

        for dy, dx in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            new_y, new_x = cur_y + dy, cur_x + dx

            # 범위를 넘거나, 장애물이거나, 이미 방문한 곳이면 -> 탐색하지 않는다.
            if new_y < 0 or new_y >= n or new_x < 0 or new_x >= m or MAP[new_y][new_x] == 1 or not visited[new_y][
                new_x]:
                continue

            if MAP[new_y][new_x] != 0:
                return MAP[new_y][new_x], cur_cnt + 1

            visited[new_y][new_x] = False  # 방문 처리
            dq.append((new_y, new_x, cur_cnt + 1))

    return -1, -1


n, m = map(int, input().split())  # n x m MAP
# 0: 빈 복도, 1: 장애물
# 2: 식구, 3: 청국장, 4: 스시, 5: 맥앤치즈
y, x = None, None
MAP = []
for i in range(n):
    MAP.append(list(map(int, input().strip())))
    for j in range(m):
        if MAP[i][j] == 2:
            y, x = i, j
            break

food, cnt = bfs(y, x)
if food == -1:
    print("NIE")
else:
    print("TAK", cnt, sep="\n")
