from sys import stdin
from collections import deque

input = stdin.readline

n, m = map(int, input().split())  # n x m MAP
MAP = []  # 0: 갈 수 없는 땅, 1: 갈 수 있는 땅, 2: 목표 지점
dist = [[0] * m for _ in range(n)]
cy, cx = None, None
for i in range(n):
    MAP.append(list(map(int, input().split())))
    for j in range(m):
        # 시작점 설정
        if MAP[i][j] == 2:
            cy, cx = i, j

dq = deque([(cy, cx, 0)])
dys, dxs = [0, 0, -1, 1], [-1, 1, 0, 0]
while dq:
    cur_y, cur_x, cnt = dq.popleft()

    for dy, dx in zip(dys, dxs):
        nxt_y, nxt_x = cur_y + dy, cur_x + dx
        # 범위를 넘지않고, 갈 수 있는 땅이라면 -> 탐색
        if 0 <= nxt_y < n and 0 <= nxt_x < m and dist[nxt_y][nxt_x] == 0 and MAP[nxt_y][nxt_x] == 1:
            dist[nxt_y][nxt_x] = cnt + 1  # 최단 거리 저장
            dq.append((nxt_y, nxt_x, cnt + 1))

# 정답 출력
for y in range(n):
    for x in range(m):
        # 갈 수 있는 곳이지만, 가지 못한 경우 -> -1 출력
        if MAP[y][x] == 1 and dist[y][x] == 0:
            print(-1, end=" ")
        # 나머지의 경우, 원래의 거리를 출력 
        elif MAP[y][x] == 1 and dist[y][x] != 0:
            print(dist[y][x], end=" ")
        else:
            print(dist[y][x], end=" ")
    print()
