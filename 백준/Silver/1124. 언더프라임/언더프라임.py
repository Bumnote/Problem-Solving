from sys import stdin

input = stdin.readline

A, B = map(int, input().split())  # A <= 언더프라임 <= B

# 에라토스테네스의 체 구현
sieve = [False, False] + [True] * 100_000
primes = []
for i in range(2, len(sieve)):
    if sieve[i]:
        primes.append(i)
        for j in range(2 * i, len(sieve), i):
            sieve[j] = False  # 소수가 아님을 처리

ans = 0
for n in range(A, B + 1):
    cnt = 0
    for prime in primes:
        while n % prime == 0:
            n //= prime
            cnt += 1

        if n == 1:
            # 인수의 개수가 소수이면 -> 언더프라임
            if sieve[cnt]:
                ans += 1
            break

print(ans)
