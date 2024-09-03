from sys import stdin

input = stdin.readline

n = int(input().rstrip())  # n: 가로의 길이

dp = [0 for _ in range(1_001)]
dp[1], dp[2] = 1, 3
for i in range(3, 1_001):
    dp[i] = dp[i - 2] * 2 + dp[i - 1]

ans = dp[n]

print(ans % 10_007)
