from sys import stdin
from math import isqrt

input = stdin.readline

LEN = 10_000
m = int(input().rstrip())
n = int(input().rstrip())
sieve = [False, False] + [True] * (LEN - 1)
for i in range(2, isqrt(LEN) + 1):
    if sieve[i]:
        for j in range(i * i, LEN + 1, i):
            sieve[j] = False  # 합성수 제거

prime = float('inf')
SUM = 0
for i in range(m, n + 1):
    if sieve[i]:
        SUM += i
        if prime > i:
            prime = i

if prime == float('inf'):
    print(-1)
else:
    print(SUM)
    print(prime)
