from sys import stdin

input = stdin.readline

n = int(input().rstrip())
boxes = list(map(int, input().split()))

dp = [1 for _ in range(n)]
MAX = 1

for i in range(1, n):
    j = i - 1
    while j >= 0:
        if boxes[j] < boxes[i]:
            dp[i] = max(dp[i], dp[j] + 1)
        j -= 1

    MAX = max(MAX, dp[i])

print(MAX)
