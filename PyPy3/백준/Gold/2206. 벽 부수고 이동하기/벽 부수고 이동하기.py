from sys import stdin
from collections import deque

input = stdin.readline


def in_range(y, x):
    return 0 <= y < n and 0 <= x < m


def bfs(y, x):
    dq = deque([(y, x, 1, 0)])
    visited = [[[False, False] for _ in range(m)] for _ in range(n)]
    visited[y][x][0] = True  # 출발 지점 방문 처리

    dys, dxs = [-1, 1, 0, 0], [0, 0, -1, 1]
    while dq:
        cur_y, cur_x, cnt, block = dq.popleft()

        if cur_y == n - 1 and cur_x == m - 1:
            return cnt

        for dy, dx in zip(dys, dxs):
            nxt_y, nxt_x = cur_y + dy, cur_x + dx

            # 다음 좌표가 범위를 넘지 않은 경우
            if in_range(nxt_y, nxt_x):
                # 다음 위치로 이동이 가능하고, 방문한 적이 없는 경우
                if MAP[nxt_y][nxt_x] == 0 and not visited[nxt_y][nxt_x][block]:
                    visited[nxt_y][nxt_x][block] = True  # 방문 처리
                    dq.append((nxt_y, nxt_x, cnt + 1, block))

                # 다음 위치가 벽이고, 부술 수 있는 경우
                elif MAP[nxt_y][nxt_x] == 1 and block == 0:
                    visited[nxt_y][nxt_x][block + 1] = True
                    dq.append((nxt_y, nxt_x, cnt + 1, block + 1))

    return -1


n, m = map(int, input().split())
MAP = [list(map(int, input().rstrip())) for _ in range(n)]

print(bfs(0, 0))
