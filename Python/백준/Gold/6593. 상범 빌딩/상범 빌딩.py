from sys import stdin
from collections import deque

input = stdin.readline


def in_range(h, y, x):
    return 0 <= h < l and 0 <= y < r and 0 <= x < c


def bfs():
    global sh, sy, sx, eh, ey, ex
    visited = [[[False for _ in range(c)] for _ in range(r)] for _ in range(l)]
    visited[sh][sy][sx] = True

    dq = deque([(sh, sy, sx, 0)])
    dhs, dys, dxs = [1, -1, 0, 0, 0, 0], [0, 0, -1, 1, 0, 0], [0, 0, 0, 0, -1, 1]
    while dq:

        cur_h, cur_y, cur_x, cnt = dq.popleft()

        if cur_h == eh and cur_y == ey and cur_x == ex:
            return cnt

        for dh, dy, dx in zip(dhs, dys, dxs):
            nxt_h, nxt_y, nxt_x = cur_h + dh, cur_y + dy, cur_x + dx
            if in_range(nxt_h, nxt_y, nxt_x) and not visited[nxt_h][nxt_y][nxt_x] and MAP[nxt_h][nxt_y][nxt_x] != "#":
                visited[nxt_h][nxt_y][nxt_x] = True
                dq.append((nxt_h, nxt_y, nxt_x, cnt + 1))

    return -1


while True:
    l, r, c = map(int, input().split())

    if l + r + c == 0:
        break

    MAP = []
    sh, sy, sx = None, None, None
    eh, ey, ex = None, None, None
    for h in range(l):
        MAP.append([list(input().rstrip()) for _ in range(r)])
        for y in range(r):
            for x in range(c):
                if MAP[h][y][x] == "S":
                    sh, sy, sx = h, y, x
                if MAP[h][y][x] == "E":
                    eh, ey, ex = h, y, x
        _ = input()

    ans = bfs()

    if ans != -1:
        print(f"Escaped in {ans} minute(s).")
    else:
        print("Trapped!")
