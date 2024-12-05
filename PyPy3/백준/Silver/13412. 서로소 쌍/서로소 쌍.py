from sys import stdin
from math import isqrt

input = stdin.readline


def get_gcd(a, b):
    if a < b:
        a, b = b, a

    while b:
        a, b = b, a % b

    return a


t = int(input().rstrip())

for _ in range(t):
    n = int(input().rstrip())

    cnt = 0
    for i in range(1, isqrt(n) + 1):
        if n % i == 0:
            GCD = get_gcd(i, n // i)
            if GCD == 1:
                cnt += 1

    print(cnt)
