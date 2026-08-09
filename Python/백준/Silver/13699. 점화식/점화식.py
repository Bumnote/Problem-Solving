from sys import stdin

input = stdin.readline

n = int(input().rstrip())

LEN = 35
dp = [1 for _ in range(LEN + 1)]
for i in range(1, LEN + 1):
    total = 0
    for j in range(i):
        total += dp[j] * dp[i - j - 1]

    dp[i] = total

print(f"{dp[n]}")
