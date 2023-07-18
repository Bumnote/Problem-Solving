from sys import stdin

input = stdin.readline

M, N = map(int, input().split())  # M이상 N이하의 소수

sieve = [False, False] + [True] * N
for i in range(2, N + 1):
    if sieve[i]:
        if M <= i <= N:
            print(i)
        for j in range(i * 2, N + 1, i):
            sieve[j] = False  # 소수가 아님을 표시
