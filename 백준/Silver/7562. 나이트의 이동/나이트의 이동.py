from sys import stdin
from collections import deque

input = stdin.readline

tc = int(input().rstrip())

for _ in range(tc):
    l = int(input().rstrip())
    canVisit = [[True] * l for _ in range(l)]
    ny, nx = map(int, input().split())
    ey, ex = map(int, input().split())

    dq = deque([(ny, nx, 0)])
    canVisit[ny][nx] = False  # 방문 처리
    dys, dxs = [-1, -2, -2, -1, 1, 2, 2, 1], [-2, -1, 1, 2, 2, 1, -1, -2]
    while dq:

        cur_y, cur_x, cnt = dq.popleft()

        if cur_y == ey and cur_x == ex:
            print(cnt)
            break

        for dy, dx in zip(dys, dxs):
            nxt_y, nxt_x = cur_y + dy, cur_x + dx
            if 0 <= nxt_y < l and 0 <= nxt_x < l and canVisit[nxt_y][nxt_x]:
                canVisit[nxt_y][nxt_x] = False  # 방문 처리
                dq.append((nxt_y, nxt_x, cnt + 1))
