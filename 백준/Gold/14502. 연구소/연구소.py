from sys import stdin
from itertools import combinations
from collections import deque

input = stdin.readline


def bfs():
    canVisit = [[True] * m for _ in range(n)]
    virus = deque()
    for y in range(n):
        for x in range(m):
            # 벽인 경우
            if MAP[y][x] == 1:
                canVisit[y][x] = False  # 방문 처리
            # 바이러스인 경우
            elif MAP[y][x] == 2:
                virus.append((y, x))
                canVisit[y][x] = False  # 방문 처리

    dys, dxs = [0, 0, -1, 1], [-1, 1, 0, 0]
    while virus:
        cur_y, cur_x = virus.popleft()

        for dy, dx in zip(dys, dxs):
            nxt_y, nxt_x = cur_y + dy, cur_x + dx
            # 범위를 넘지 않고, 방문 가능하며, 빈칸인 경우 -> 전염
            if 0 <= nxt_y < n and 0 <= nxt_x < m and canVisit[nxt_y][nxt_x] and MAP[nxt_y][nxt_x] == 0:
                virus.append((nxt_y, nxt_x))
                canVisit[nxt_y][nxt_x] = False  # 방문 처리

    safe = 0
    for y in range(n):
        for x in range(m):
            # 바이러스가 퍼지지 않은 안전 구역의 개수
            if canVisit[y][x]:
                safe += 1

    return safe


n, m = map(int, input().split())  # n x m MAP
MAP = []  # 0: 빈 칸, 1: 벽, 2: 바이러스
walls = []
for y in range(n):
    MAP.append(list(map(int, input().split())))
    for x in range(m):
        if MAP[y][x] == 0:
            walls.append((y, x))  # 빈 칸의 위치 저장

MAX = 0
for wall in combinations(walls, 3):
    for y, x in wall:
        MAP[y][x] = 1  # 벽을 세운다.

    # 바이러스 터뜨리기
    MAX = max(MAX, bfs())

    for y, x in wall:
        MAP[y][x] = 0  # 벽을 부순다.

print(MAX)
