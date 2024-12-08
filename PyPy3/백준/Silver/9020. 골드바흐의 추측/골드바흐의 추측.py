from sys import stdin, maxsize
from math import isqrt

input = stdin.readline

t = int(input().rstrip())

LEN = 10_000
sieve = [False, False] + [True] * (LEN - 1)

dic = {}
for i in range(2, isqrt(LEN) + 1):
    if sieve[i]:
        for j in range(i * i, LEN + 1, i):
            sieve[j] = False  # 합성수

for _ in range(t):
    n = int(input().rstrip())
    n1, n2 = None, None
    for i in range(2, n // 2 + 1):
        MIN = maxsize
        if sieve[i] and sieve[n - i]:
            diff = abs(i - (n - i))
            if diff < MIN:
                MIN = diff
                n1, n2 = i, n - i

    print(f"{n1} {n2}")
