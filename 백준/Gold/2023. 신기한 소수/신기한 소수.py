from sys import stdin
from math import isqrt

input = stdin.readline


def isPrime(x):
    for i in range(2, isqrt(x) + 1):
        if x % i == 0:
            return False
    return True


def dfs(x):
    if len(x) == n:
        print(x)
        return

    for nxt in odds:
        if isPrime(int(x + nxt)):
            dfs(x + nxt)


n = int(input().strip())  # n: n자리 숫자 (1 <= n <= 8)
odds = ["1", "3", "5", "7", "9"]

dfs("2")
dfs("3")
dfs("5")
dfs("7")
