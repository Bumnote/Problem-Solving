from sys import stdin, setrecursionlimit

setrecursionlimit(10 ** 6)
input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # n x m 행렬
c_map = [list(map(int, input().split())) for _ in range(n)]
t = int(input().strip())

## 문제 해결 부분 ##
color = [[] for _ in range(n)]
visited = [[True] * m for _ in range(n)]

for y in range(n):
    for x in range(0, m * 3 - 2, 3):
        total = 0
        for i in range(3):
            total += c_map[y][x + i]

        if total >= t * 3:
            color[y].append(255)
        else:
            color[y].append(0)


def dfs(y, x):
    for dy, dx in ((-1, 0), (1, 0), (0, 1), (0, -1)):
        new_y, new_x = y + dy, x + dx
        # 범위를 넘거나, 이미 방문했거나, 픽셀값이 255가 아니면 -> continue
        if new_y < 0 or new_y >= n or new_x < 0 or new_x >= m or not visited[new_y][new_x] or color[new_y][new_x] != 255:
            continue
        visited[new_y][new_x] = False  # 방문 처리
        dfs(new_y, new_x)


answer = 0
for y in range(n):
    for x in range(m):
        # 방문 가능하고, 픽셀값이 255이면 -> dfs 탐색
        if visited[y][x] and color[y][x] == 255:
            visited[y][x] = False  # 방문 처리
            dfs(y, x)
            answer += 1

print(answer)
