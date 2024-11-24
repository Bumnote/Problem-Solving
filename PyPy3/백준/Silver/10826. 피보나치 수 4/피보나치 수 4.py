from sys import stdin

input = stdin.readline

n = int(input().rstrip())
dp = [0, 1]

for i in range(2, n + 1):
    dp.append(dp[i - 2] + dp[i - 1])

print(dp[n])
