from sys import stdin

input = stdin.readline

n = int(input().rstrip())
# 3kg, 5kg 봉지만 존재
INF = int(1e9)
dp = [INF for _ in range(5_001)]  # 최대 5000kg 가능
dp[3], dp[5] = 1, 1

for i in range(6, 5_001):
    # dp 테이블 갱신 
    dp[i] = min(dp[i], dp[i - 3] + 1, dp[i - 5] + 1)

print(dp[n] if dp[n] != INF else -1)
