from sys import stdin
from math import isqrt

input = stdin.readline

A, B = map(int, input().split())  # A <= 거의 소수 <= B (1 <= A <= B <= 10^14)

MAX_LENGTH = isqrt(B)
sieve = [False, False] + [True] * (MAX_LENGTH - 1)

ans = 0
for i in range(2, MAX_LENGTH + 1):
    if sieve[i]:
        temp = i
        n = 2
        # 큰 수를 작은 수로 표현하기 위해서 이항 정리 활용
        while i <= B / temp:
            if A / temp <= i:
                ans += 1
            temp *= i

        for j in range(2 * i, MAX_LENGTH + 1, i):
            sieve[j] = False  # 소수가 아님을 처리

print(ans)
