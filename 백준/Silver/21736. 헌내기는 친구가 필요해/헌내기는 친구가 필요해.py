from sys import stdin
from collections import deque

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # n x m 행렬
campus = []
d_y, d_x = 0, 0
for y in range(n):
    campus.append(list(input().strip()))
    for x in range(m):
        # 도연이의 위치 저장
        if campus[y][x] == "I":
            d_y, d_x = y, x

## 문제 해결 부분 ##
visited = [[True] * m for _ in range(n)]
cnt = 0


def bfs(y, x):
    global cnt
    deq = deque()
    deq.append((y, x))
    visited[y][x] = False  # 도연이 방문 처리

    while deq:
        cur_y, cur_x = deq.popleft()
        if campus[cur_y][cur_x] == "P":
            cnt += 1

        for dy, dx in ((-1, 0), (1, 0), (0, 1), (0, -1)):
            new_y, new_x = cur_y + dy, cur_x + dx
            # 범위를 넘거나, 이미 방문했거나, 벽이면 -> continue
            if new_y < 0 or new_y >= n or new_x < 0 or new_x >= m or not visited[new_y][new_x] or campus[new_y][
                new_x] == "X":
                continue
            visited[new_y][new_x] = False  # 방문 처리 -> 재방문 불가
            deq.append((new_y, new_x))


bfs(d_y, d_x)
print(cnt if cnt != 0 else "TT")
