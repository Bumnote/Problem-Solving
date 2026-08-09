from sys import stdin
from collections import deque

input = stdin.readline


def in_range(y, x):
    return 0 <= y < h and 0 <= x < w


def bfs(sy, sx, ey, ex):
    INF = float('inf')
    mirror = [[[INF] * 4 for _ in range(w)] for _ in range(h)]
    visited = [[[False] * 4 for _ in range(w)] for _ in range(h)]

    dq = deque()
    for i in range(4):
        dq.append((sy, sx, i, 0))
        mirror[sy][sx][i] = 0

    # (0, 1, 2, 3) = (U, R, D, L)
    dys, dxs = [-1, 0, 1, 0], [0, 1, 0, -1]
    while dq:
        cur_y, cur_x, cur_d, cnt = dq.popleft()
        # 현재 방향, 왼쪽 90도, 오른쪽 90도
        for nxt_d in [cur_d, (cur_d + 4 - 1) % 4, (cur_d + 1) % 4]:
            nxt_y, nxt_x = cur_y + dys[nxt_d], cur_x + dxs[nxt_d]
            # 범위를 넘지 않고, 벽이 아니고, -> 탐색 진행
            if in_range(nxt_y, nxt_x) and MAP[nxt_y][nxt_x] != "*":
                # 해당 방향으로 방문한 적이 없는 경우
                if not visited[nxt_y][nxt_x][nxt_d]:
                    visited[nxt_y][nxt_x][nxt_d] = True  # 방문 처리
                    # 방향이 같은 경우
                    if nxt_d == cur_d:
                        mirror[nxt_y][nxt_x][nxt_d] = cnt  # 거울 개수 변화 x
                        dq.append((nxt_y, nxt_x, nxt_d, cnt))
                    # 방향이 꺾이는 경우
                    else:
                        mirror[nxt_y][nxt_x][nxt_d] = cnt + 1  # 거울 개수 변화 o
                        dq.append((nxt_y, nxt_x, nxt_d, cnt + 1))
                # # 해당 방향으로 방문한 적이 있지만, 거울의 개수가 적은 경우
                elif mirror[nxt_y][nxt_x][nxt_d] > cnt:
                    # 방향이 같은 경우
                    if nxt_d == cur_d:
                        mirror[nxt_y][nxt_x][nxt_d] = cnt  # 거울 개수 변화 x
                        dq.append((nxt_y, nxt_x, nxt_d, cnt))
                    # 방향이 꺾이는 경우
                    else:
                        mirror[nxt_y][nxt_x][nxt_d] = cnt + 1  # 거울 개수 변화 o
                        dq.append((nxt_y, nxt_x, nxt_d, cnt + 1))

    return min(mirror[ey][ex])


w, h = map(int, input().split())
points = []
MAP = []

for i in range(h):
    MAP.append(list(input().strip()))
    for j in range(w):
        if MAP[i][j] == "C":
            points.append((i, j))

sy, sx, ey, ex = *points[0], *points[1]
ans = bfs(sy, sx, ey, ex)
print(ans)
