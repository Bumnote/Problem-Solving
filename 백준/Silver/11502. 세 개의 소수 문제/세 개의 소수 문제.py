from sys import stdin
from math import isqrt

input = stdin.readline

sieve = [False, False] + [True] * 1_000
primes = []
for i in range(2, 1000):
    if sieve[i]:
        primes.append(i)  # 소수들만 저장
        for j in range(2 * i, 1000, i):
            sieve[j] = False  # 소수가 아님을 처리

tc = int(input().strip())  # tc: 테스트 케이스

for _ in range(tc):
    n = int(input().strip())  # n: 홀수인 소수 (7 <= n < 1_000)

    length = len(primes)


    def solve():
        for i in range(length):
            for j in range(length):
                for k in range(length):
                    if n < (primes[i] + primes[j] + primes[k]):
                        break
                    if n == (primes[i] + primes[j] + primes[k]):
                        return primes[i], primes[j], primes[k]

        return 0


    print(*solve(), sep=" ")
