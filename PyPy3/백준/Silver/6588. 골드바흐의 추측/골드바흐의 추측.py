from sys import stdin
from math import isqrt

input = stdin.readline

LEN = 1_000_000
sieve = [False, False] + [True] * (LEN - 1)
for i in range(2, isqrt(LEN) + 1):
    if sieve[i]:
        for j in range(i * i, LEN + 1, i):
            sieve[j] = False  # 합성수 제거

while True:
    n = int(input().rstrip())
    if n == 0:
        break

    for i in range(2, n // 2 + 1):
        if sieve[i] and sieve[n - i]:
            print(f"{n} = {i} + {n - i}")
            break
