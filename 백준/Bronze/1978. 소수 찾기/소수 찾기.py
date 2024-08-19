from sys import stdin

input = stdin.readline

_ = int(input().rstrip())
lst = list(map(int, input().split()))

# 에라토스테네스의 체
MAX = 1_000
sieve = [False, False] + [True] * (MAX - 1)
for i in range(2, int(MAX ** (1 / 2)) + 1):
    if sieve[i]:
        for j in range(i * i, MAX + 1, i):
            sieve[j] = False  # 배수는 소수가 아니다.

cnt = 0
for num in lst:
    if sieve[num]:
        cnt += 1

print(cnt)
