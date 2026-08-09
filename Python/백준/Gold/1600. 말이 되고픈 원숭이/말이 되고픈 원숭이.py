from sys import stdin
from collections import deque

input = stdin.readline


def in_range(y, x):
    return 0 <= y < h and 0 <= x < w


def bfs():
    visited = [[[False] * (k + 1) for _ in range(w)] for _ in range(h)]
    visited[0][0][0] = 0  # 출발점 방문 처리 [y][x][k]
    dq = deque([(0, 0, 0, 0)])

    while dq:
        cur_y, cur_x, dist, k_cnt = dq.popleft()

        if cur_y == h - 1 and cur_x == w - 1:
            return dist

        # 원숭이가 말처럼 이동할 수 있는 경우
        if k_cnt < k:
            for dy, dx in zip(dhys, dhxs):
                nxt_y, nxt_x = cur_y + dy, cur_x + dx
                # 방문 가능하거나, 장애물이 아닌 경우
                if in_range(nxt_y, nxt_x) and not visited[nxt_y][nxt_x][k_cnt + 1] and MAP[nxt_y][nxt_x] != 1:
                    visited[nxt_y][nxt_x][k_cnt + 1] = True  # 방문 처리
                    dq.append((nxt_y, nxt_x, dist + 1, k_cnt + 1))

        # 원숭이가 원숭이처럼 이동할 수 있는 경우
        for dy, dx in zip(dmys, dmxs):
            nxt_y, nxt_x = cur_y + dy, cur_x + dx
            # 방문 가능하거나, 장애물이 아닌 경우
            if in_range(nxt_y, nxt_x) and not visited[nxt_y][nxt_x][k_cnt] and MAP[nxt_y][nxt_x] != 1:
                visited[nxt_y][nxt_x][k_cnt] = True  # 방문 처리
                dq.append((nxt_y, nxt_x, dist + 1, k_cnt))

    return -1


k = int(input().rstrip())
w, h = map(int, input().split())
# 0: 평지, 1: 장애물
MAP = [list(map(int, input().split())) for _ in range(h)]

dhys, dhxs = [-2, -1, 1, 2, 2, 1, -1, -2], [1, 2, 2, 1, -1, -2, -2, -1]
dmys, dmxs = [-1, 1, 0, 0], [0, 0, -1, 1]
ans = bfs()
print(ans)
