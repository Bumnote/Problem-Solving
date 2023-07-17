from sys import stdin

input = stdin.readline

n, m = map(int, input().split())  # n x n 행렬, m: 테스트 케이스
matrix = [list(map(int, input().split())) for _ in range(n)]
dp = [[0] * (n + 1) for _ in range(n + 1)]

# dp 초기화
dp[1][1] = matrix[0][0]
for t in range(2, n + 1):
    dp[1][t] = dp[1][t - 1] + matrix[0][t - 1]
    dp[t][1] = dp[t - 1][1] + matrix[t - 1][0]

for i in range(2, n + 1):
    for j in range(2, n + 1):
        dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]

for _ in range(m):
    y1, x1, y2, x2 = map(int, input().split())
    ans = dp[y2][x2] - dp[y2][x1 - 1] - dp[y1 - 1][x2] + dp[y1 - 1][x1 - 1]
    print(ans)
