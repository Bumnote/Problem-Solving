from sys import stdin
from math import isqrt

input = stdin.readline


def is_under_prime(num):
    return 1 if sieve[prime[num]] else 0


a, b = map(int, input().split())

# 에라토스테네스의 체 구현
LEN = 100_000
sieve = [False, False] + [True] * (LEN - 1)
prime = [0 for _ in range(LEN + 1)]
for i in range(2, LEN + 1):
    if sieve[i]:
        for j in range(i * 2, LEN + 1, i):
            sieve[j] = False  # 합성수 제거
            curr = j
            while curr % i == 0:
                prime[j] += 1
                curr //= i

cnt = 0
for num in range(a, b + 1):
    cnt += is_under_prime(num)

print(cnt)
