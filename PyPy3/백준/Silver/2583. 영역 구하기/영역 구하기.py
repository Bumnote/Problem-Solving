from sys import stdin
from collections import deque

input = stdin.readline


def draw(y1, x1, y2, x2):
    for y in range(y1, y2):
        for x in range(x1, x2):
            MAP[y][x] = 1
            visited[y][x] = True


def bfs(y, x):
    dq = deque([(y, x)])
    wide = 1

    dys, dxs = [-1, 1, 0, 0], [0, 0, -1, 1]
    while dq:
        cur_y, cur_x = dq.popleft()

        for dy, dx in zip(dys, dxs):
            nxt_y, nxt_x = cur_y + dy, cur_x + dx
            if 0 <= nxt_y < n and 0 <= nxt_x < m and not visited[nxt_y][nxt_x]:
                visited[nxt_y][nxt_x] = True
                wide += 1
                dq.append([nxt_y, nxt_x])

    return wide


n, m, k = map(int, input().split())
MAP = [[0 for _ in range(m)] for _ in range(n)]
visited = [[False for _ in range(m)] for _ in range(n)]

for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    draw(y1, x1, y2, x2)

cnt = 0
wides = []
for y in range(n):
    for x in range(m):
        if MAP[y][x] == 0 and not visited[y][x]:
            visited[y][x] = True
            wide = bfs(y, x)
            wides.append(wide)
            cnt += 1

print(cnt)
print(*sorted(wides))
