from sys import stdin
from collections import deque

input = stdin.readline

R, C = map(int, input().split())
MAP = []
water = deque()
me = deque()
for y in range(R):
    MAP.append(list(input().strip()))
    for x in range(C):
        if MAP[y][x] == "S":
            me.append((y, x, 0))  # 내 위치 저장
        elif MAP[y][x] == "*":
            water.append((y, x, 0))  # 물의 위치 저장


# .: 비어있는 곳, *: 물, X: 돌, D: 굴, S: 고슴도치 위치
# S -> D


def bfs():
    # 물의 이동 구현
    while water:
        cur_y, cur_x, cur_cnt = water.popleft()

        visited_w[cur_y][cur_x] = cur_cnt

        for ny, nx in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            new_y, new_x = cur_y + ny, cur_x + nx
            # 범위를 넘지 않고, 방문한 적이 없다면 -> append()
            if new_y < 0 or new_y >= R or new_x < 0 or new_x >= C:
                continue

            if visited_w[new_y][new_x] == -1 and MAP[new_y][new_x] == ".":
                water.append((new_y, new_x, cur_cnt + 1))

    # 고슴도치의 이동 구현 -> 물보다 빨리 움직이면서 굴에 가야만 한다.
    while me:
        cur_y, cur_x, cur_cnt = me.popleft()

        if MAP[cur_y][cur_x] == "D":
            return cur_cnt

        visited_m[cur_y][cur_x] = cur_cnt

        for ny, nx in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            new_y, new_x = cur_y + ny, cur_x + nx
            if new_y < 0 or new_y >= R or new_x < 0 or new_x >= C:
                continue

            if visited_m[new_y][new_x] == -1 and MAP[new_y][new_x] != "X" and \
                    (visited_w[new_y][new_x] > cur_cnt + 1 or MAP[new_y][new_x] == "D"):
                me.append((new_y, new_x, cur_cnt + 1))

    return "KAKTUS"


# 물 먼저 이동
visited_w = [[-1] * C for _ in range(R)]
visited_m = [[-1] * C for _ in range(R)]

print(bfs())
