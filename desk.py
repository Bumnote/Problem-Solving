from sys import stdin
from collections import deque

input = stdin.readline

n = int(input().strip())  # n x n MAP

MAP = [list(map(int, input().split())) for _ in range(n)]


def bfs(y, x):
    visited = [[True] * n for _ in range(n)]
    visited[y][x] = False  # 출발점 방문 표시
    dq = deque([(y, x)])

    while dq:
        cur_y, cur_x = dq.popleft()

        if cur_y == n - 1 and cur_x == n - 1:
            return True

        l = MAP[cur_y][cur_x]

        for dy, dx in ((0, l), (l, 0)):
            new_y, new_x = cur_y + dy, cur_x + dx
            # 범위를 넘거나, 이미 방문했던 곳이라면 -> 탐색하지 않는다.
            if new_y < 0 or new_y >= n or new_x < 0 or new_x >= n or not visited[new_y][new_x]:
                continue
            visited[new_y][new_x] = False
            dq.append((new_y, new_x))

    return False


if bfs(0, 0):
    print("HaruHaru")
else:
    print("Hing")
