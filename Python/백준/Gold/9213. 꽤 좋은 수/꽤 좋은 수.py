from sys import stdin
from math import isqrt

input = stdin.readline

LEN = 1_000_000
sieve = [False, False] + [True] * (LEN - 1)
divisor_sum = [1 for _ in range(LEN + 1)]

for i in range(2, isqrt(LEN) + 1):
    if sieve[i]:
        for j in range(i * i, LEN + 1, i):
            if i != j // i:
                divisor_sum[j] += (i + j // i)
            else:
                divisor_sum[j] += i

tc = 1
while True:

    start, stop, badness = map(int, input().split())
    if start + stop + badness == 0:
        break

    cnt = 0
    for num in range(start, stop + 1):
        diff = abs(num - divisor_sum[num])
        if diff <= badness:
            cnt += 1

    print(f"Test {tc}: {cnt}")
    tc += 1
