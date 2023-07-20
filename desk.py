from sys import stdin

input = stdin.readline

n = int(input().strip())  # n번째 소수
sieve = [False, False] + [True] * 110_000
cnt = 0
for i in range(2, len(sieve)):
    if sieve[i]:
        cnt += 1
        # n번째 소수인 경우 -> 출력 후 break
        if cnt == n:
            print(i)
            break
        for j in range(2 * i, len(sieve), i):
            sieve[j] = False  # 소수가 아님을 처리
