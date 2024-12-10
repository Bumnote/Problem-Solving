from sys import stdin
from math import isqrt

input = stdin.readline

LEN = 1120
# 에라토스테네스의 체를 활용한 소수 판별
sieve = [False, False] + [True] * (LEN - 1)
for i in range(2, isqrt(LEN) + 1):
    if sieve[i]:
        for j in range(i * i, LEN + 1, i):
            sieve[j] = False  # 합성수 제거

primes = [i for i in range(2, LEN + 1) if sieve[i]]
dp = [[0 for _ in range(15)] for _ in range(LEN + 1)]
dp[0][0] = 1

for prime in primes:
    for k in range(14, 0, -1):
        for i in range(2, LEN + 1):
            if i >= prime:
                dp[i][k] += dp[i - prime][k - 1]

t = int(input().rstrip())

for _ in range(t):
    # n을 서로 다른 k개의 소수의 합으로
    n, k = map(int, input().split())

    print(dp[n][k])
