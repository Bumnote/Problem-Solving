from sys import stdin
from math import isqrt

input = stdin.readline

tc = int(input().strip())  # tc: 테스트 케이스

sieve = [False, False] + [True] * 1_299_709
for i in range(2, isqrt(1_299_709) + 1):
    if sieve[i]:
        for j in range(2 * i, 1_299_709 + 1, i):
            sieve[j] = False  # 소수가 아님을 처리

for _ in range(tc):
    n = int(input().strip())  # 정수 k

    # 주어진 수가 소수라면 -> 0 출력
    if sieve[n]:
        print(0)
    # 주어진 수가 합성수라면 -> 길이 출력
    else:
        left, right = 0, 0
        while not sieve[n - left]:
            left += 1

        while not sieve[n + right]:
            right += 1

        print(right + left)
