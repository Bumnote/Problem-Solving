from sys import stdin
from collections import deque

input = stdin.readline


def init():
    for y in range(n):
        for x in range(m):
            if grid[y][x] == 2:
                push(y, x, 0)
                return


def in_range(y, x):
    return 0 <= y < n and 0 <= x < m


def push(y, x, step):
    q.append((y, x, step))
    visited[y][x] = True
    grid[y][x] = step


def bfs():
    dys, dxs = [0, 0, -1, 1], [1, -1, 0, 0]

    while q:
        y, x, step = q.popleft()

        for dy, dx in zip(dys, dxs):
            new_y, new_x = y + dy, x + dx
            if in_range(new_y, new_x) and not visited[new_y][new_x] and grid[new_y][new_x] != 0:
                push(new_y, new_x, step + 1)


n, m = map(int, input().split())  # n: 세로 / m: 가로
grid = [list(map(int, input().split())) for _ in range(n)]
visited = [[False for _ in range(m)] for _ in range(n)]

q = deque()

init()

bfs()

# 정답 출력
for y in range(n):
    for x in range(m):
        # 방문을 헸다면 --> 거리 출력
        if visited[y][x]:
            print(grid[y][x], end=" ")
        # 방문을 하지 않았고, 원래 갈 수 없는 땅이라면 --> 0 출력
        elif grid[y][x] == 0:
            print(0, end=" ")
        # 원래 갈 수 있는 땅이지만, 도달할 수 없다면 --> -1 출력 
        else:
            print(-1, end=" ")
    print()
