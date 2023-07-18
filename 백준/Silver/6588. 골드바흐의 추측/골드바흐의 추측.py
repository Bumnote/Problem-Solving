from sys import stdin
from math import isqrt

input = stdin.readline

V = 1_000_000
# 에라토스테네스의 체 구현
sieve = [False, False] + [True] * V
for i in range(2, isqrt(V) + 1):
    if not sieve[i]:
        continue

    for j in range(2 * i, V + 1, i):
        sieve[j] = False  # 소수가 아님을 표시

while True:
    n = int(input().strip())  # n: 짝수 (6 <= n <= 1_000_000)
    if n == 0:
        break

    MAX, a, b = -1, 0, 0
    for x in range(3, (n // 2) + 1, 2):
        if sieve[x] and sieve[n - x]:
            MAX = n - 2 * x
            a, b = x, n - x
            break

    if MAX == -1:
        print("Goldbach's conjecture is wrong.")
    else:
        print(f"{n} = {a} + {b}")
