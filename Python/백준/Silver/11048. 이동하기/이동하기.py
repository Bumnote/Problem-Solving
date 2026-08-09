from sys import stdin

input = stdin.readline

n, m = map(int, input().split())
MAP = [list(map(int, input().split())) for _ in range(n)]
# dp 초기화
dp = [[0 for _ in range(m)] for _ in range(n)]
dp[0][0] = MAP[0][0]

dys, dxs = [1, 0, 1], [0, 1, 1]
for i in range(n):
    for j in range(m):
        for dy, dx in zip(dys, dxs):
            ny, nx = i + dy, j + dx
            # 범위를 넘지 않는다면 -> dp 진행
            if 0 <= ny < n and 0 <= nx < m:
                dp[ny][nx] = max(dp[ny][nx], dp[i][j] + MAP[ny][nx])

print(dp[n - 1][m - 1])
