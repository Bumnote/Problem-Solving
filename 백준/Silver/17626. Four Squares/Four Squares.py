from sys import stdin
from math import isqrt

input = stdin.readline

n = int(input().rstrip())  # n: 자연수
dp = [i for i in range(n + 1)]

# dp 초기화
for i in range(1, isqrt(n) + 1):
    dp[i * i] = 1  # 제곱 수를 표현하는 방법은 1개

# dp 점화식: dp[i] = dp[isqrt(i) ** 2] + dp[n - isqrt(n) ** 2]
for i in range(2, n + 1):
    num = 1
    # 현재 수보다 작은 제곱 수에 대해서 브루트 포스 적용
    while i >= num ** 2:
        pow_num = num ** 2
        dp[i] = min(dp[i], dp[pow_num] + dp[i - pow_num])
        num += 1

print(dp[n])
