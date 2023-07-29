from sys import stdin
from collections import deque

input = stdin.readline

R, C = map(int, input().split())  # R x C MAP
MAP = []
# .: 빈 칸, *: 물, X: 돌, D: 비버 굴, S: 고슴 도치 위치  | S -> D 갈 수 있는 지 확인
water = deque()  # 물의 위치 정보
me = deque()  # 나의 위치 정보
visited_w = [[True] * C for _ in range(R)]
visited_m = [[True] * C for _ in range(R)]

for y in range(R):
    MAP.append(list(input().strip()))
    for x in range(C):
        if MAP[y][x] == "*":
            water.append((y, x, 0))  # 물 위치 저장
            visited_w[y][x] = False  # 방문 처리
        if MAP[y][x] == "S":
            me.append((y, x, 0))  # 내 위치 저장
            visited_m[y][x] = False  # 방문 처리


def bfs():
    # 물 먼저 이동
    while water:
        cur_y, cur_x, cur_cnt = water.popleft()

        MAP[cur_y][cur_x] = cur_cnt  # MAP에다가 물의 현재 위치 표현
        for dy, dx in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            new_y, new_x = cur_y + dy, cur_x + dx
            # 범위를 벗어난다면 -> continue
            if new_y < 0 or new_y >= R or new_x < 0 or new_x >= C:
                continue
            # 방문이 가능하고, 돌이 아니고, 비버의 굴이 아니라면 -> 물 이동
            if visited_w[new_y][new_x] and MAP[new_y][new_x] != "X" and MAP[new_y][new_x] != "D":
                visited_w[new_y][new_x] = False  # 방문 처리
                water.append((new_y, new_x, cur_cnt + 1))

    # 물 이동 후 나 이동 -> 물이 도착하기 전에 내가 도착하면서 움직여 나간다.
    while me:
        cur_y, cur_x, cur_cnt = me.popleft()

        # 움직인 현재 위치가 비버의 굴이라면 -> 현재까지 움직인 횟수 return
        if MAP[cur_y][cur_x] == "D":
            return cur_cnt

        for dy, dx in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            new_y, new_x = cur_y + dy, cur_x + dx
            # 범위를 벗어난다면 -> continue
            if new_y < 0 or new_y >= R or new_x < 0 or new_x >= C:
                continue
            # 방문한 적이 없고, 돌이 아니고, 물보다 먼저 도착하거나, 빈칸이거나(물이 없는 경우를 위해서),다음 구역이 비버의 굴이라면 -> 이동
            if visited_m[new_y][new_x] and MAP[new_y][new_x] != "X" and (
                    MAP[new_y][new_x] == "D" or MAP[new_y][new_x] == "." or MAP[new_y][new_x] > cur_cnt + 1):
                visited_m[new_y][new_x] = False  # 방문 처리
                me.append((new_y, new_x, cur_cnt + 1))

    # 비버의 굴로 이동할 수 없는 경우 -> "KAKTUS" return
    return "KAKTUS"


print(bfs())
