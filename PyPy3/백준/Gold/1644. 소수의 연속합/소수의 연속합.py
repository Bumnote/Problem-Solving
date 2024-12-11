from sys import stdin
from math import isqrt

input = stdin.readline

LEN = 4_000_000
# 에라토스테네스의 체 구현
sieve = [False, False] + [True] * (LEN - 1)
for i in range(2, isqrt(LEN) + 1):
    if sieve[i]:
        for j in range(i * i, LEN + 1, i):
            sieve[j] = False  # 합성수 제거

primes = [i for i in range(2, LEN + 1) if sieve[i]]
dp = [0 for _ in range(LEN + 1)]
n = int(input().rstrip())

for i in range(len(primes)):
    SUM = 0
    for j in range(len(primes)):
        # 범위를 넘거나, 최댓값을 뛰어넘는다면 break
        if i + j >= len(primes) or SUM + primes[i + j] > LEN:
            break
        SUM += primes[i + j]
        dp[SUM] += 1

print(dp[n])
