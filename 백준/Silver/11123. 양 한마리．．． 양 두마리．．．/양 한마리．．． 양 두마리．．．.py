from sys import stdin, setrecursionlimit

setrecursionlimit(10 ** 4)
input = stdin.readline

tc = int(input().strip())  # 테스트 케이스 입력
for _ in range(tc):
    ## 변수 입력 부분 ##
    n, m = map(int, input().split())  # n: 행, m: 열
    field = [list(input().strip()) for _ in range(n)]
    visited = [[True] * m for _ in range(n)]


    ## 문제 해결 부분 ##
    def dfs(y, x):

        for dy, dx in ((-1, 0), (1, 0), (0, 1), (0, -1)):
            new_y, new_x = y + dy, x + dx

            if new_y < 0 or new_y >= n or new_x < 0 or new_x >= m or not visited[new_y][new_x] or field[new_y][
                new_x] == ".":
                continue

            visited[new_y][new_x] = False  # 방문 처리
            dfs(new_y, new_x)


    cnt = 0
    for y in range(n):
        for x in range(m):
            # 방문 가능하고, 양(#)이라면 -> dfs 탐색
            if visited[y][x] and field[y][x] == "#":
                visited[y][x] = False  # 방문 처리
                dfs(y, x)
                cnt += 1

    print(cnt)
