from sys import stdin
from math import isqrt

input = stdin.readline

t = int(input().rstrip())

# 에라토스테네스의 체 구현
LEN = 1_299_709
sieve = [False, True] + [True] * (LEN - 1)
for i in range(2, isqrt(LEN) + 1):
    if sieve[i]:
        for j in range(i * i, LEN + 1, i):
            sieve[j] = False

for _ in range(t):
    k = int(input().rstrip())
    if sieve[k]:
        print(0)
    else:
        s, e = None, None

        num = 1
        while True:

            if sieve[k - num]:
                s = k - num
                break
            num += 1

        num = 1
        while True:

            if sieve[k + num]:
                e = k + num
                break
            num += 1

        print(e - s)
