from sys import stdin

input = stdin.readline

dp = [[0, 0] for _ in range(41)]
dp[0][0], dp[1][1] = 1, 1  # dp 초기값 셋팅
for i in range(2, 41):
    dp[i] = [i + j for i, j in zip(dp[i - 1], dp[i - 2])]

t = int(input().rstrip())
for _ in range(t):
    n = int(input().rstrip())
    print(*dp[n])
