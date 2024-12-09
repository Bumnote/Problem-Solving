from sys import stdin

input = stdin.readline

n = int(input().rstrip())
lst = list(map(int, input().split()))
dp = [1 for _ in range(n)]

LEN = 1
for i in range(1, n):
    j = i - 1
    # 현재 숫자보다 작은 인덱스에 대한 dp값을 찾는다.
    while j >= 0:
        if lst[j] < lst[i]:
            dp[i] = max(dp[i], dp[j] + 1)
        j -= 1

    LEN = max(LEN, dp[i])

print(LEN)
