from sys import stdin
from math import isqrt

input = stdin.readline

tc = int(input().strip())  # tc: 테스트 케이스
# 에라토스테네스의 체 구현
sieve = [False, False] + [True] * 100_000
primes = []
for i in range(2, 100_000):
    if sieve[i]:
        primes.append(i)  # 소수만 따로 리스트에 담는다.
        for j in range(2 * i, 100_000 + 1, i):
            sieve[j] = False  # 소수가 아님을 처리

for _ in range(tc):
    n = int(input().strip())  # n: 양의 정수 (2 <= n <= 100_000)
    # n이 소수라면 -> 자기 자신이 인수 그 자체이다.
    if sieve[n]:
        print(f"{n} {1}")
    else:
        for prime in primes:
            # 해당 소수로 나눠질때까지 나눈다.
            cnt = 0
            while n % prime == 0:
                n //= prime
                cnt += 1  # 나눈 횟수를 더해간다.

            if cnt != 0:
                print(f"{prime} {cnt}")
            # 모두 다 나눠졌다는 의미이므로 결과 출력
            if n == 1:
                break
