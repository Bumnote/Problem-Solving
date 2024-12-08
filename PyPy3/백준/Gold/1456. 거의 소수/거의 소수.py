from sys import stdin
from math import isqrt

input = stdin.readline

a, b = map(int, input().split())

LEN = 10 ** 7
sieve = [False, False] + [True] * (LEN - 1)
for i in range(2, isqrt(LEN) + 1):
    if sieve[i]:
        for j in range(i * i, LEN + 1, i):
            sieve[j] = False  # 합성수 제거

cnt = 0
for i in range(2, isqrt(b) + 1):
    if sieve[i]:
        num = i * i
        while num <= b:
            if a <= num <= b:
                cnt += 1
            num *= i

print(cnt)
