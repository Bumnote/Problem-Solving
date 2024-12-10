from sys import stdin, setrecursionlimit
from collections import deque

setrecursionlimit(10 ** 4)
input = stdin.readline


def dfs(cur_y, cur_x):
    for dy, dx in zip(dys, dxs):
        nxt_y, nxt_x = cur_y + dy, cur_x + dx
        if 0 <= nxt_y < n and 0 <= nxt_x < n and not visited[nxt_y][nxt_x] and MAP[nxt_y][nxt_x] == 1:
            visited[nxt_y][nxt_x] = True  # 방문 처리
            dfs(nxt_y, nxt_x)


def bfs(y, x):
    global MIN

    dq = deque([(y, x, 0)])
    while dq:

        cur_y, cur_x, cnt = dq.popleft()

        for dy, dx in zip(dys, dxs):
            nxt_y, nxt_x = cur_y + dy, cur_x + dx
            if 0 <= nxt_y < n and 0 <= nxt_x < n and not visited[nxt_y][nxt_x]:
                if MAP[nxt_y][nxt_x] == 0:
                    visited[nxt_y][nxt_x] = True  # 방문 처리
                    dq.append((nxt_y, nxt_x, cnt + 1))
                # 다른 육지와 맞닿아 있는 경우
                else:
                    MIN = min(MIN, cnt)  # 최단 거리 갱신
                    return 

n = int(input().rstrip())
# 0: 바다 / 1: 육지
MAP = [list(map(int, input().split())) for _ in range(n)]
edges = []
dys, dxs = [-1, 1, 0, 0], [0, 0, -1, 1]

for i in range(n):
    for j in range(n):
        # 육지인 경우
        if MAP[i][j] == 1:
            flag = False
            for dy, dx in zip(dys, dxs):
                ny, nx = i + dy, j + dx
                if 0 <= ny < n and 0 <= nx < n:
                    if MAP[ny][nx] == 0:
                        flag = True

            # 육지의 가장자리인 경우
            if flag:
                edges.append((i, j))

MIN = float('inf')
for ey, ex in edges:
    visited = [[False for _ in range(n)] for _ in range(n)]
    visited[ey][ex] = True  # 방문 처리
    dfs(ey, ex)  # 같은 육지는 모두 방문 처리
    bfs(ey, ex)

print(MIN)
