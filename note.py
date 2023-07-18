from sys import stdin
from collections import deque

input = stdin.readline

N, M = map(int, input().split())  # N x M 행렬
matrix = [list(map(int, input().strip())) for _ in range(N)]  # 0: 이동 x, 1: 이동 o


def bfs(y, x):
    deq = deque()
    deq.append((y, x, 1))
    visited = [[True] * M for _ in range(N)]
    visited[y][x] = False  # 방문 처리

    while deq:
        cur_y, cur_x, cur_cnt = deq.popleft()

        if cur_y == N - 1 and cur_x == M - 1:
            return cur_cnt

        for dy, dx in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            new_y, new_x = cur_y + dy, cur_x + dx

            if new_y < 0 or new_y >= N or new_x < 0 or new_x >= M or not visited[new_y][new_x] or matrix[new_y][
                new_x] == 0:
                continue

            visited[new_y][new_x] = False  # 방문처리
            deq.append((new_y, new_x, cur_cnt + 1))


print(bfs(0, 0))
