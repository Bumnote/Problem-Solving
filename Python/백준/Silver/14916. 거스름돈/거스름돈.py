from sys import stdin

input = stdin.readline

n = int(input().rstrip())

MAX = 100_000
INF = float('inf')
dp = [INF] * (MAX + 1)
dp[0], dp[2], dp[5] = 0, 1, 1

for i in range(3, MAX + 1):
    if i < 5:
        dp[i] = dp[i - 2] + 1
    else:
        dp[i] = min(dp[i - 2], dp[i - 5]) + 1

print(dp[n] if dp[n] != INF else -1)
