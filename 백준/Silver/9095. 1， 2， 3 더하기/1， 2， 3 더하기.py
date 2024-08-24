from sys import stdin

input = stdin.readline

t = int(input().rstrip())
dp = [0] * 11
dp[1], dp[2], dp[3] = 1, 2, 4

# dp 점화식 dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]
for i in range(4, 11):
    dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]

for _ in range(t):
    n = int(input().rstrip())
    print(dp[n])  # n에 관한 dp값 출력
