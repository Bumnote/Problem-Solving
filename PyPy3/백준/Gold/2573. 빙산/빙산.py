from sys import stdin
from collections import deque

input = stdin.readline


def bfs(y, x):
    dq = deque([(y, x)])

    dys, dxs = [-1, 1, 0, 0], [0, 0, -1, 1]
    while dq:

        cur_y, cur_x = dq.popleft()

        cnt = 0
        for dy, dx in zip(dys, dxs):
            nxt_y, nxt_x = cur_y + dy, cur_x + dx
            if 0 <= nxt_y < n and 0 <= nxt_x < m and not visited[nxt_y][nxt_x]:
                if MAP[nxt_y][nxt_x][0] > 0:
                    visited[nxt_y][nxt_x] = True  # 방문 처리
                    dq.append((nxt_y, nxt_x))
                if MAP[nxt_y][nxt_x][0] == 0:
                    cnt += 1

        MAP[cur_y][cur_x][1] = cnt

    for i in range(n):
        for j in range(m):
            if MAP[i][j][0] > 0:
                MAP[i][j][0] = max(0, MAP[i][j][0] - MAP[i][j][1])
                MAP[i][j][1] = 0

    return


n, m = map(int, input().split())
MAP = [[[0, 0] for _ in range(m)] for _ in range(n)]
for i in range(n):
    lst = list(map(int, input().split()))
    for j in range(m):
        MAP[i][j][0] = lst[j]

total, time = 0, 0
while True:
    cnt = 0
    visited = [[False for _ in range(m)] for _ in range(n)]
    flag = True
    for y in range(n):
        for x in range(m):
            if not visited[y][x] and MAP[y][x][0] > 0:
                flag = False
                visited[y][x] = True
                bfs(y, x)
                cnt += 1

    if flag:
        time = 0
        break

    if cnt >= 2:
        break

    time += 1

print(time)
