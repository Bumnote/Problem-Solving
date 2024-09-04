from sys import stdin
from math import isqrt

input = stdin.readline


def isPrime(x):
    for i in range(2, 1_000_000 + 1):
        if x % i == 0:
            return False

    return True


n = int(input().rstrip())

for _ in range(n):
    s = int(input().rstrip())
    print("YES" if isPrime(s) else "NO")
