from sys import stdin, setrecursionlimit

setrecursionlimit(10 ** 8)
input = stdin.readline


def dfs(cur_y, cur_x):
    global MAX

    if dp[cur_y][cur_x] != -1:
        return dp[cur_y][cur_x]

    dp[cur_y][cur_x] = 1  # 기본 방문 체크
    for dy, dx in zip(dys, dxs):
        nxt_y, nxt_x = cur_y + dy, cur_x + dx
        # 범위를 넘지 않고, 현재 위치의 대나무보다 다음 위치의 대나무가 더 많다면 -> 탐색
        if 0 <= nxt_y < n and 0 <= nxt_x < n and MAP[cur_y][cur_x] < MAP[nxt_y][nxt_x]:
            cnt = 1
            cnt += dfs(nxt_y, nxt_x)
            dp[cur_y][cur_x] = max(dp[cur_y][cur_x], cnt)
            MAX = max(MAX, dp[i][j])

    return dp[cur_y][cur_x]


n = int(input().rstrip())
MAP = [list(map(int, input().split())) for _ in range(n)]
dp = [[-1 for _ in range(n)] for _ in range(n)]

MAX = 1
dys, dxs = [-1, 1, 0, 0], [0, 0, -1, 1]
for i in range(n):
    for j in range(n):
        if dp[i][j] == -1:
            dfs(i, j)

print(MAX)
