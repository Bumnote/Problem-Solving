from sys import stdin
from collections import deque

input = stdin.readline


def bfs(y, x):
    deq = deque()  # 최단 거리를 구하기 위해서 너비 우선 탐색 활용
    deq.append((y, x, 0))
    visited = [[True] * m for _ in range(n)]  # 방문 확인용
    visited[y][x] = False  # 방문 처리

    while deq:
        cur_y, cur_x, cur_cnt = deq.popleft()
        # 상어와 마주쳤다면, 해당 거리값을 return
        if grid[cur_y][cur_x] == 1:
            return cur_cnt
        # 8 방향 탐색
        for dy, dx in ((-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1)):
            new_y, new_x = cur_y + dy, cur_x + dx
            # 범위를 넘거나, 방문한 적이 있다면 -> continue
            if new_y < 0 or new_y >= n or new_x < 0 or new_x >= m or not visited[new_y][new_x]:
                continue
            visited[new_y][new_x] = False  # 방문 처리
            deq.append((new_y, new_x, cur_cnt + 1))


## 변수 입력 부분 ##
n, m = map(int, input().split())  # (n, m) 2 <= n, m <= 50
grid = [list(map(int, input().split())) for _ in range(n)]  # 0: 빈 칸, 1: 상어
dist = [[0] * m for _ in range(n)]  # 안전 거리 정보만을 담을 리스트

## 문제 해결 부분 ##
max_safe_dist = 0  # 안전 거리의 최댓값
for y in range(n):
    for x in range(m):
        # 모든 빈 칸마다 안전 거리의 최댓값을 구한다. -> 브루트 포스
        if grid[y][x] == 0:
            dist[y][x] = bfs(y, x)
            # 최댓값 계속 갱신
            if max_safe_dist < dist[y][x]:
                max_safe_dist = dist[y][x]
        continue

print(max_safe_dist)
