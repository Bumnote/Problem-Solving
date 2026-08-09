from sys import stdin

input = stdin.readline

n = int(input().rstrip())

dp = [0 for _ in range(n + 2)]
plan = [0] + [list(map(int, input().split())) for _ in range(n)]

MAX = 0
for i in range(1, n + 1):
    if dp[i] == 0:
        dp[i] = MAX

    if dp[i] != 0:
        MAX = max(MAX, dp[i])

    if i + plan[i][0] <= n + 1:
        dp[i + plan[i][0]] = max(dp[i + plan[i][0]], dp[i] + plan[i][1], MAX + plan[i][1])
        MAX = max(MAX, dp[i])

print(max(dp))