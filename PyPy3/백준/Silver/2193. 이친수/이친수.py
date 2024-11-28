from sys import stdin

input = stdin.readline

n = int(input().rstrip())  # n: 자릿 수
LEN = 90

dp = [1 for _ in range(LEN + 1)]

for i in range(3, LEN + 1):
    dp[i] = dp[i - 2] + dp[i - 1]

print(dp[n])
