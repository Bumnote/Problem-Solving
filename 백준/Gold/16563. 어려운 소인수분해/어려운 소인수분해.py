from sys import stdin
from math import isqrt

input = stdin.readline

N = int(input().strip())  # N: 자연수의 개수
K_list = list(map(int, input().split()))  # N개의 수

# 소인수 분해는 소수들의 나눗셈을 활용한다.
# 에라토스테네스의 체 구현
MAX_NUM = isqrt(5_000_000)
sieve = [i for i in range(5_000_000 + 1)]
for i in range(2, MAX_NUM + 1):
    if sieve[i] == i:
        for j in range(2 * i, 5_000_000 + 1, i):
            if sieve[j] == j:
                sieve[j] = i  # 가장 작은 소인수를 저장

for k in K_list:

    while k > 1:
        print(sieve[k], end=" ")
        k = k // sieve[k]
    print()
