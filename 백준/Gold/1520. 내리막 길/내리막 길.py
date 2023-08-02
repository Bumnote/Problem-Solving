from sys import stdin, setrecursionlimit

setrecursionlimit(10_000)
input = stdin.readline

N, M = map(int, input().split())  # N x M MAP
MAP = [list(map(int, input().split())) for _ in range(N)]
dp = [[-1] * M for _ in range(N)]


def dfs(y, x):
    # 현재 위치가 도착 지점이라면 -> 1 return
    if y == N - 1 and x == M - 1:
        return 1

    if dp[y][x] != -1:
        return dp[y][x]

    dp[y][x] = 0
    for dy, dx in ((0, 1), (0, -1), (1, 0), (-1, 0)):
        new_y, new_x = y + dy, x + dx
        # 범위를 넘는 다면 -> 탐색하지 않는다.
        if new_y < 0 or new_y >= N or new_x < 0 or new_x >= M:
            continue

        if MAP[y][x] > MAP[new_y][new_x]:
            dp[y][x] += dfs(new_y, new_x)

    return dp[y][x]


print(dfs(0, 0))
