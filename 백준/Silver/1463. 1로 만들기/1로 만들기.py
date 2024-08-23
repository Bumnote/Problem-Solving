from sys import stdin

input = stdin.readline

n = int(input().rstrip())
MAX = 1_000_000
dp = [0] * (MAX + 1)

for i in range(2, MAX + 1):
    if i % 2 == 0 and i % 3 == 0:
        dp[i] = min(dp[i // 2] + 1, dp[i // 3] + 1, dp[i - 1] + 1)
    elif i % 3 == 0:
        dp[i] = min(dp[i // 3] + 1, dp[i - 1] + 1)
    elif i % 2 == 0:
        dp[i] = min(dp[i // 2] + 1, dp[i - 1] + 1)
    else:
        dp[i] = dp[i - 1] + 1

print(dp[n])
