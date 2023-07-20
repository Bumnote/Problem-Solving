from sys import stdin

input = stdin.readline

k = int(input().strip())  # k번째 소수

# 에라토스테네스의 체 구현
sieve = [False, False] + [True] * 500_000
primes = []
for i in range(2, len(sieve)):
    if sieve[i]:
        primes.append(i)
        for j in range(2 * i, len(sieve), i):
            sieve[j] = False  # 소수가 아님을 처리

print(primes[k - 1])
