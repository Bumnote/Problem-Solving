from sys import stdin
from math import isqrt

input = stdin.readline

MAX_LENGTH = 10_000_000
sieve = [False, False] + [True] * (MAX_LENGTH - 1)
primes = []
for i in range(2, MAX_LENGTH + 1):
    if sieve[i]:
        primes.append(i)
        for j in range(2 * i, MAX_LENGTH + 1, i):
            sieve[j] = False  # 소수가 아님을 처리

A, B = map(int, input().split())  # A <= 거의 소수 <= B (1 <= A <= B <= 10^14)

ans = 0
for prime in primes:
    n = 2
    while prime ** n <= B:
        if A <= prime ** n:
            ans += 1
        n += 1

print(ans)
