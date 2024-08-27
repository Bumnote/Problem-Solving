from sys import stdin

input = stdin.readline

n, m = map(int, input().split())
MAP = [list(map(int, input().split())) for _ in range(n)]

dp = [[0 for _ in range(n)] for _ in range(n)]

# dp 초기화 작업
for i in range(n):
    dp[i][0] = MAP[i][0]

# 한 행에 대해서 dp 작업
for i in range(n):
    for j in range(1, n):
        dp[i][j] = dp[i][j - 1] + MAP[i][j]

# 1행부터 시작하여 그 아래 행에 대한 dp값을 더해가는 작업
for i in range(1, n):
    for j in range(1, n):
        dp[i][j] = dp[i][j] + dp[i - 1][j]

# 0열에 대한 dp 작업
for i in range(1, n):
    dp[i][0] = dp[i][0] + dp[i - 1][0]

for _ in range(m):
    y1, x1, y2, x2 = map(int, input().split())
    y1, x1, y2, x2 = y1 - 1, x1 - 1, y2 - 1, x2 - 1

    # (0, 0)부터 시작인 경우
    if y1 == 0 and x1 == 0:
        print(dp[y2][x2])
    # (0, x1)부터 시작인 경우
    elif y1 == 0:
        print(dp[y2][x2] - dp[y2][x1 - 1])
    # (y1, 0)부터 시작인 경우
    elif x1 == 0:
        print(dp[y2][x2] - dp[y1 - 1][x2])
    # (y1, x1)부터 시작인 경우
    else:
        print(dp[y2][x2] - dp[y1 - 1][x2] - dp[y2][x1 - 1] + dp[y1 - 1][x1 - 1])  # 중복되는 경우를 더해준다
