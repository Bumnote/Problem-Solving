from sys import stdin

input = stdin.readline

n = int(input().rstrip())

MAP = [list(map(int, input().split())) for _ in range(n)]
dp = [[[0, 0] for _ in range(3)] for _ in range(2)]

# dp 초기화
# dp[i][j][0]: i행, j열까지 최댓값
# dp[i][j][1]: i행, j열까지 최솟값
for i in range(3):
    dp[0][i][0] = MAP[0][i]  # 최댓값 초기화
    dp[0][i][1] = MAP[0][i]  # 최솟값 초기화
    dp[1][i][0] = MAP[0][i]
    dp[1][i][1] = MAP[0][i]

for i in range(1, n):
    for j in range(3):
        if j == 0:
            dp[1][j][0] = max(dp[0][j][0], dp[0][j + 1][0]) + MAP[i][j]
            dp[1][j][1] = min(dp[0][j][1], dp[0][j + 1][1]) + MAP[i][j]
        elif j == 1:
            dp[1][j][0] = max(dp[0][j - 1][0], dp[0][j][0], dp[0][j + 1][0]) + MAP[i][j]
            dp[1][j][1] = min(dp[0][j - 1][1], dp[0][j][1], dp[0][j + 1][1]) + MAP[i][j]
        else:
            dp[1][j][0] = max(dp[0][j - 1][0], dp[0][j][0]) + MAP[i][j]
            dp[1][j][1] = min(dp[0][j - 1][1], dp[0][j][1]) + MAP[i][j]

    for k in range(3):
        dp[0][k][0] = dp[1][k][0]
        dp[0][k][1] = dp[1][k][1]

MAX, MIN = 0, int(1e9)
for i in range(3):
    MAX = max(MAX, dp[1][i][0])
    MIN = min(MIN, dp[1][i][1])

print(f"{MAX} {MIN}")
