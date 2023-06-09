from sys import stdin, setrecursionlimit

input = stdin.readline
setrecursionlimit(100 * 100)


def in_range(y, x):
    return 0 <= y < n and 0 <= x < m


def dfs(y, x, f):
    global cheese

    # 치즈의 가장자리를 녹이는 dfs
    if f:
        visited[y][x] = False  # 방문 처리

        for dy, dx in ((-1, 0), (1, 0), (0, 1), (0, -1)):
            c_y, c_x = y + dy, x + dx
            if in_range(c_y, c_x) and grid[c_y][c_x] == 1:
                grid[c_y][c_x] = "C"

            new_y, new_x = y + dy, x + dx
            if not in_range(new_y, new_x) or not visited[new_y][new_x] or grid[new_y][new_x] != 0:
                continue

            dfs(new_y, new_x, True)

    # 치즈 조각의 개수를 구하는 dfs
    else:
        cheese += 1
        visited[y][x] = False  # 방문 처리

        for dy, dx in ((-1, 0), (1, 0), (0, 1), (0, -1)):
            new_y, new_x = y + dy, x + dx
            if not in_range(new_y, new_x) or not visited[new_y][new_x] or grid[new_y][new_x] != 1:
                continue

            dfs(new_y, new_x, False)


## 변수 입력 부분 ##
n, m = map(int, input().split())  # n: 가로, m: 세로 (1 <= n, m <= 100)
grid = [list(map(int, input().split())) for _ in range(n)]

last_cheese = 0  # 마지막 다 녹기 직전의 치즈 개수
cnt = 0  # 치즈가 다 녹을때까지 진행된 횟수

## 문제 해결 부분 ##
while True:
    visited = [[True] * m for _ in range(n)]  # 방문 확인용
    flag = True  # while문 탈출 flag

    # 치즈 조각 개수 구하는 코드
    cheese = 0
    for y in range(n):
        for x in range(m):
            # 좌표값이 1이면서 방문이 가능하면 -> dfs 탐색
            if grid[y][x] == 1 and visited[y][x]:
                flag = False
                dfs(y, x, False)  # dfs탐색이 끝날때마다 1개씩 추가

    if flag:
        print(cnt, last_cheese, sep="\n")
        break

    dfs(0, 0, True)  # 치즈 겉면을 녹이는 dfs 탐색
    last_cheese = cheese

    # "C"인 부분을 0으로 바꾸어주는 코드
    for y in range(n):
        for x in range(m):
            if grid[y][x] == "C":
                grid[y][x] = 0

    cnt += 1  # 진행 횟수 추가
