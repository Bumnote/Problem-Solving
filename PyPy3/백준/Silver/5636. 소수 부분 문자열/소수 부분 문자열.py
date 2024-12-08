from sys import stdin
from math import isqrt

input = stdin.readline

LEN = 100_000
sieve = [False, False] + [True] * (LEN - 1)
for i in range(2, isqrt(LEN) + 1):
    if sieve[i]:
        for j in range(i * i, LEN + 1, i):
            sieve[j] = False  # 합성수 제거

while True:

    n = int(input().rstrip())
    if n == 0:
        break

    ans = 0
    nums = str(n)
    for i in range(len(nums)):
        for j in range(i, len(nums)):
            new_num = int(nums[i: j + 1])
            if new_num <= LEN and sieve[new_num]:
                if ans < new_num:
                    ans = new_num

    print(ans)
