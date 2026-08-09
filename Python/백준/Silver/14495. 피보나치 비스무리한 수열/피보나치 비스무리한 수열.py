from sys import stdin

input = stdin.readline

n = int(input().rstrip())
LEN = 116

dp = [1 for _ in range(LEN + 1)]

for i in range(4, LEN + 1):
    dp[i] = dp[i - 3] + dp[i - 1]

print(dp[n])
