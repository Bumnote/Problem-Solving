from sys import stdin
from math import isqrt

input = stdin.readline


def isTrue(num):
    s = {num}
    while True:
        lst = list(map(int, str(num)))
        total = sum([i * i for i in lst])
        if total == 1:
            return True

        if total in s:
            break

        s.add(total)
        num = total

    return False


n = int(input().rstrip())
sieve = [False, False] + [True] * (n - 1)

for i in range(2, isqrt(n) + 1):
    if sieve[i]:
        for j in range(i * i, n + 1, i):
            sieve[j] = False

for num in range(2, n + 1):
    if sieve[num] and isTrue(num):
        print(num)
