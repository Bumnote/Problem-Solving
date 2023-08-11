from sys import stdin
from math import isqrt
from itertools import combinations

input = stdin.readline

n, m = map(int, input().split())  # n: 소들의 수, m: 선별할 소의 수
H_i = list(map(int, input().split()))

MAX_NUM = 9_000
sieve = [False, False] + [True] * (MAX_NUM - 1)
for i in range(2, isqrt(MAX_NUM) + 1):
    if sieve[i]:
        for j in range(2 * i, MAX_NUM, i):
            sieve[j] = False  # 소수가 아님 처리

ans = set()
for elem in combinations(H_i, m):
    if sieve[sum(elem)]:
        ans.add(sum(elem))

if len(ans) == 0:
    print(-1)
else:
    print(*sorted(list(ans)))
