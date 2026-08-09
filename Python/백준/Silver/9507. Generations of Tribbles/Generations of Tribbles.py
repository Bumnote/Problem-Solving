from sys import stdin

input = stdin.readline

t = int(input().rstrip())

LEN = 67
dp = [1 for _ in range(LEN + 1)]
dp[2], dp[3] = 2, 4

for i in range(4, LEN + 1):
    dp[i] = dp[i - 4] + dp[i - 3] + dp[i - 2] + dp[i - 1]

for _ in range(t):
    n = int(input().rstrip())

    print(dp[n])
