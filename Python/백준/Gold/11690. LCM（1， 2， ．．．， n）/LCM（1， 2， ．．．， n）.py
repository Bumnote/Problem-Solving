from sys import stdin
from math import isqrt

input = stdin.readline

LEN = 10 ** 8
MOD = 2 ** 32
sieve = bytearray(LEN + 1)
sieve[0], sieve[1] = 1, 1
for i in range(2, isqrt(LEN) + 1):
    if sieve[i] == 0:
        for j in range(i * i, LEN + 1, i):
            sieve[j] = 1  # 합성수 제거

primes = [i for i in range(2, LEN + 1) if sieve[i] == 0]

LCM = 1
n = int(input().rstrip())
for prime in primes:
    if prime > n:
        break

    MUL = prime
    while MUL <= n:
        LCM = (LCM * prime) % MOD
        MUL *= prime

print(LCM)
