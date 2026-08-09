from sys import stdin
from collections import deque

input = stdin.readline


def bfs(y, x):
    dq = deque([(y, x)])
    wide = 1

    dys, dxs = [-1, 1, 0, 0], [0, 0, -1, 1]
    while dq:
        cur_y, cur_x = dq.popleft()

        for dy, dx in zip(dys, dxs):
            nxt_y, nxt_x = cur_y + dy, cur_x + dx

            if 0 <= nxt_y < n and 0 <= nxt_x < m and not visited[nxt_y][nxt_x] and MAP[nxt_y][nxt_x] == 1:
                visited[nxt_y][nxt_x] = True
                wide += 1
                dq.append((nxt_y, nxt_x))

    return wide


n, m = map(int, input().split())
MAP = [list(map(int, input().split())) for _ in range(n)]

visited = [[False for _ in range(m)] for _ in range(n)]
cnt, wide = 0, 0

for y in range(n):
    for x in range(m):
        if not visited[y][x] and MAP[y][x] == 1:
            visited[y][x] = True
            wide = max(wide, bfs(y, x))
            cnt += 1
            
print(f"{cnt}\n{wide}")
