from sys import stdin
from math import isqrt

input = stdin.readline

n = int(input().rstrip())

LEN = 100_000
# dp 초기화
dp = [float('inf') for _ in range(LEN + 1)]
for i in range(1, isqrt(LEN) + 1):
    dp[i ** 2] = 1

# 문제 풀이
for i in range(1, LEN + 1):
    for j in range(1, isqrt(i) + 1):
        dp[i] = min(dp[i], dp[i - j * j] + 1)

print(dp[n])
