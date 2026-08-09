from sys import stdin

input = stdin.readline

n = int(input().rstrip())

LEN = 1_000_000
dp = [0 for _ in range(LEN + 1)]
dp[1] = 1
dp[2] = 2
dp[3] = 3

for i in range(4, LEN + 1):
    dp[i] = (dp[i - 2] + dp[i - 1]) % 15746

print(dp[n])
