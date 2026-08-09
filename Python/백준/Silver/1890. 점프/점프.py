from sys import stdin

input = stdin.readline

n = int(input().rstrip())

MAP = [list(map(int, input().split())) for _ in range(n)]
dp = [[0 for _ in range(n)] for _ in range(n)]

# 초기값 설정
dp[0][0] = 1

for i in range(n):
    for j in range(n):
        if i == n - 1 and j == n - 1:
            continue

        v = MAP[i][j]
        # 오른쪽 범위를 넘지 않는 경우
        if j + v < n:
            dp[i][j + v] += dp[i][j]

        # 아래쪽 범위를 넘지 않는 경우
        if i + v < n:
            dp[i + v][j] += dp[i][j]

print(dp[n - 1][n - 1])
