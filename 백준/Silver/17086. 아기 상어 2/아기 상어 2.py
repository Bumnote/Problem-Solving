from sys import stdin
from collections import deque

input = stdin.readline


def bfs(y, x):
    deq = deque()
    deq.append((y, x, 0))
    visited = [[True] * m for _ in range(n)]
    visited[y][x] = False  # 방문 처리

    while deq:
        cur_y, cur_x, cur_cnt = deq.popleft()
        if grid[cur_y][cur_x] == 1:
            return cur_cnt

        for dy, dx in ((-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1)):
            new_y, new_x = cur_y + dy, cur_x + dx
            if new_y < 0 or new_y >= n or new_x < 0 or new_x >= m or not visited[new_y][new_x]:
                continue
            visited[new_y][new_x] = False  # 방문 처리
            deq.append((new_y, new_x, cur_cnt + 1))


## 변수 입력 부분 ##
n, m = map(int, input().split())  # (n, m) 2 <= n, m <= 50
grid = [list(map(int, input().split())) for _ in range(n)]  # 0: 빈 칸, 1: 상어
dist = [[0] * m for _ in range(n)]

## 문제 해결 부분 ##
max_safe_dist = 0
for y in range(n):
    for x in range(m):
        if grid[y][x] == 0:
            dist[y][x] = bfs(y, x)
            if max_safe_dist < dist[y][x]:
                max_safe_dist = dist[y][x]
        continue

# for y in range(n):
#     for x in range(m):
#         print(dist[y][x], end=" ")
#     print()
# print()
print(max_safe_dist)
"""
5 4
0 0 1 0
0 0 0 0
1 0 0 0
0 0 0 0
0 0 0 1

2

7 4
0 0 0 1
0 1 0 0
0 0 0 0
0 0 0 1
0 0 0 0
0 1 0 0
0 0 0 1

2
"""
