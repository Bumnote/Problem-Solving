from sys import stdin, maxsize
from math import isqrt

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # n: 제곱수의 합

## 문제 해결 부분 ##
INF = maxsize
dp = [0] + [INF] * (n)
for i in range(1, isqrt(n) + 1):
    temp = i ** 2
    dp[temp] = 1
    for j in range(temp + 1, n + 1):
        dp[j] = min(dp[temp] + dp[j - temp], dp[j])

print(dp[n])
