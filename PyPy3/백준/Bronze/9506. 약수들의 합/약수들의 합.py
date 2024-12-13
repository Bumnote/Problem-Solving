from sys import stdin
from math import isqrt

input = stdin.readline

LEN = 100_000
sieve = [False, False] + [True] * (LEN - 1)
for i in range(2, isqrt(LEN) + 1):
    if sieve[i]:
        for j in range(i * i, LEN + 1, i):
            sieve[j] = False  # 합성수 제거

while True:
    n = int(input().rstrip())
    if n == -1:
        break

    SUM = 1
    lst = [1]
    for prime in range(2, n):
        if n % prime == 0:
            SUM += prime
            lst.append(prime)

    if SUM == n:
        print(f"{n} =", end=" ")
        print(*lst, sep=" + ")
    else:
        print(f"{n} is NOT perfect.")
