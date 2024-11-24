from sys import stdin

input = stdin.readline

k = int(input().rstrip())

# 초기 상테 : A
MAX = 45
dp = [[0, 0] for _ in range(MAX + 1)]
dp[0] = [1, 0]

for i in range(1, MAX + 1):
    dp[i][0] = dp[i - 1][1]
    dp[i][1] = dp[i - 1][0] + dp[i - 1][1]

print(f"{dp[k][0]} {dp[k][1]}")
