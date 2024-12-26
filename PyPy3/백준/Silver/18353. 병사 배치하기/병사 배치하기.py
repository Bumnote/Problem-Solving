from sys import stdin

input = stdin.readline

n = int(input().rstrip())
n_lst = list(map(int, input().split()))

# dp[i]: i번째까지 자신보다 큰 숫자의 최대 개수 (기본값 1)
dp = [1 for _ in range(n)]
dp[0] = 1

MAX = 1
# dp 초기화
for i in range(1, n):
    j = i - 1
    while j >= 0:
        if n_lst[j] > n_lst[i]:
            dp[i] = max(dp[i], dp[j] + 1)
        j -= 1

    MAX = max(MAX, dp[i])

print(n - MAX)
