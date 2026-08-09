from sys import stdin
from collections import deque

input = stdin.readline


def burning():
    dys, dxs = [-1, 1, 0, 0], [0, 0, -1, 1]
    while fires:
        cur_y, cur_x, cnt = fires.popleft()
        for dy, dx in zip(dys, dxs):
            nxt_y, nxt_x = cur_y + dy, cur_x + dx
            # 범위를 넘지 않고, 방문한 적이 없고, 벽이 아니라면 -> 불이 옮겨 붙는다.
            if 0 <= nxt_y < r and 0 <= nxt_x < c and visited[nxt_y][nxt_x] == INF and MAP[nxt_y][nxt_x] != "#":
                visited[nxt_y][nxt_x] = cnt + 1
                fires.append((nxt_y, nxt_x, cnt + 1))


def move(y, x):
    sg = deque([(y, x, 0)])
    visited[y][x] = 0
    dys, dxs = [-1, 1, 0, 0], [0, 0, -1, 1]
    while sg:

        cur_y, cur_x, cnt = sg.popleft()
        for dy, dx in zip(dys, dxs):
            nxt_y, nxt_x = cur_y + dy, cur_x + dx
            # 범위를 넘지 않고,
            if 0 <= nxt_y < r and 0 <= nxt_x < c:
                # 불보다 더 빠르게 움직일 수 있고, 벽이 아니라면 -> 지훈이가 이동할 수 있다.
                if cnt + 1 < visited[nxt_y][nxt_x] and MAP[nxt_y][nxt_x] != "#":
                    visited[nxt_y][nxt_x] = cnt + 1
                    sg.append((nxt_y, nxt_x, cnt + 1))
            # 범위를 넘는다면 -> 탈출할 수 있다.
            else:
                return cnt + 1

    return "IMPOSSIBLE"


t = int(input().rstrip())
for _ in range(t):
    c, r = map(int, input().split())
    MAP = []
    sy, sx = 0, 0
    fires = deque()
    INF = float('inf')
    visited = [[INF for _ in range(c)] for _ in range(r)]
    for i in range(r):
        MAP.append(list(input().strip()))
        for j in range(c):
            # 상근이 위치 저장
            if MAP[i][j] == "@":
                sy, sx = i, j
            # 불이 난 위치 저장
            elif MAP[i][j] == "*":
                visited[i][j] = 0
                fires.append((i, j, 0))

            elif MAP[i][j] == "#":
                visited[i][j] = -1  # 방문 처리

    # 먼저 불을 먼저 태운다.
    burning()
    # 불이 난 시간보다 앞지를 수 있다면 상근이가 움직일 수 있다.
    print(move(sy, sx))
