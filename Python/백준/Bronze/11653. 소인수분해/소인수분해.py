from sys import stdin
from math import isqrt

input = stdin.readline

n = int(input().rstrip())

sieve = [False, False] + [True] * (n - 1)
for i in range(2, isqrt(n) + 1):
    if sieve[i]:
        for j in range(i * i, n + 1, i):
            sieve[j] = False  # 합성수 제거

num = n
for i in range(2, n + 1):
    if sieve[i] and num % i == 0:
        while num % i == 0:
            print(i)
            num //= i

    if num == 1:
        break
