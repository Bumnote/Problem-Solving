from sys import stdin
from math import isqrt

input = stdin.readline

a, b = map(int, input().split())  # a <= 소수 <= b


def isPalin(num):
    return num == int(str(num)[::-1])


def isPrime(num):
    if num == 1:
        return False

    for i in range(2, isqrt(num) + 1):
        if num % i == 0:
            return False
    return True


for num in range(a, b + 1):
    if isPalin(num) and isPrime(num):
        print(num)
    continue

print(-1)
