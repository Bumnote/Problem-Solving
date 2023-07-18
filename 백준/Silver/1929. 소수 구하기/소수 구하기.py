from sys import stdin
from math import isqrt

input = stdin.readline

M, N = map(int, input().split())  # M이상 N이하의 소수

sieve = [False, False] + [True] * N
for i in range(2, isqrt(N) + 1):
    if sieve[i]:
        for j in range(i * 2, N + 1, i):
            sieve[j] = False  # 소수가 아님을 표시

# M이상 N이하의 소수인 것만 출력 
for i in range(M, N + 1):
    if sieve[i]:
        print(i)
