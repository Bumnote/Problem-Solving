from sys import stdin

input = stdin.readline

n = int(input().rstrip())

LEN = 1_000_000
dp = [0 for _ in range(LEN + 1)]
dp[1] = 1

DIV = 1_000_000_007
for i in range(2, LEN + 1):
    dp[i] = (dp[i - 2] + dp[i - 1]) % DIV

print(dp[n])
