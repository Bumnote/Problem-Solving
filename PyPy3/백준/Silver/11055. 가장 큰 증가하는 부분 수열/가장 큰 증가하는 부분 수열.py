from sys import stdin

input = stdin.readline

n = int(input().rstrip())
lst = list(map(int, input().split()))

dp = [i for i in lst]

MAX = dp[0]
for i in range(1, n):
    j = i - 1
    while j >= 0:
        if lst[j] < lst[i]:
            dp[i] = max(dp[i], dp[j] + lst[i])
        j -= 1

    MAX = max(MAX, dp[i])

print(MAX)
