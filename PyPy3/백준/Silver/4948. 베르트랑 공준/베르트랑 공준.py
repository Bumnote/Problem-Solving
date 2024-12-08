from sys import stdin
from math import isqrt

input = stdin.readline

LEN = 123_456 * 2
sieve = [False, False] + [True] * (LEN - 1)
for i in range(2, isqrt(LEN) + 1):
    if sieve[i]:
        for j in range(i * i, LEN + 1, i):
            sieve[j] = False  # 합성수 제거

while True:
    n = int(input().rstrip())
    if n == 0:
        break

    cnt = 0
    for i in range(n + 1, 2 * n + 1):
        if sieve[i]:
            cnt += 1

    print(cnt)
