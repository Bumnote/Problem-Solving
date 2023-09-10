from sys import stdin

input = stdin.readline

n = int(input().strip())  # n: 집의 크기
MAP = [list(map(int, input().split())) for _ in range(n)]
dp = [[[0 for _ in range(n)] for _ in range(n)] for _ in range(3)]

# 0: 가로, 1: 대각선, 2: 세로
dp[0][0][1] = 1  # 초기화
for i in range(2, n):
    # 벽이 아니라면 -> 가로로 파이프를 놓을 수 있다.
    if MAP[0][i] == 0:
        dp[0][0][i] = 1
    # 벽을 만난다면 -> 더 이상, 가로로 파이프를 놓을 수 없다.
    else:
        break

# dp 진행
for i in range(1, n):
    for j in range(1, n):
        # 벽이 아니라면 -> dp 진행
        if MAP[i][j] == 0:
            # 가로로 놓을 수 있는 경우 (->->, \->)
            dp[0][i][j] = dp[0][i][j - 1] + dp[1][i][j - 1]

            # 세로로 놓을 수 있는 경우 ( | |, \ |)
            dp[2][i][j] = dp[2][i - 1][j] + dp[1][i - 1][j]

            # 대각선으로 놓을 수 있는 경우 (공간이 필요) (-\, \ \, |\)
            if MAP[i - 1][j] == 0 and MAP[i][j] == 0 and MAP[i][j - 1] == 0:
                dp[1][i][j] = dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1]

print(dp[0][n - 1][n - 1] + dp[1][n - 1][n - 1] + dp[2][n - 1][n - 1])
