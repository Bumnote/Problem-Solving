from sys import stdin

input = stdin.readline

n = int(input().rstrip())
lst = list(map(int, input().split()))

dp = [1 for _ in range(n)]
ans = 1
# up
for i in range(1, n):
    if lst[i - 1] <= lst[i]:
        dp[i] = dp[i - 1] + 1
        ans = max(ans, dp[i])
    else:
        continue

dp = [1 for _ in range(n)]
# down
for i in range(1, n):
    if lst[i - 1] >= lst[i]:
        dp[i] = dp[i - 1] + 1
        ans = max(ans, dp[i])
    else:
        continue

print(ans)
