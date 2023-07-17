from sys import stdin

input = stdin.readline

n, m = map(int, input().split())  # n x m 행렬
matrix = [list(map(int, input().split())) for _ in range(n)]
k = int(input().strip())

# dp 초기 설정
dp = [[0] * (m + 1) for _ in range(n + 1)]
dp[1][1] = matrix[0][0]
for i in range(2, m + 1):
    dp[1][i] = dp[1][i - 1] + matrix[0][i - 1]

for j in range(2, n + 1):
    dp[j][1] = dp[j - 1][1] + matrix[j - 1][0]

for y in range(2, n + 1):
    for x in range(2, m + 1):
        dp[y][x] = matrix[y - 1][x - 1] + dp[y - 1][x] + dp[y][x - 1] - dp[y - 1][x - 1]

for _ in range(k):
    y1, x1, y2, x2 = map(int, input().split())  # (y1, x1) ~ (y2, x2)
    ans = dp[y2][x2] - dp[y1 - 1][x2] - dp[y2][x1 - 1] + dp[y1 - 1][x1 - 1]
    print(ans)
