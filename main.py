from sys import stdin
from math import isqrt

input = stdin.readline

## 변수 입력 부분 ##
MIN, MAX = map(int, input().split())  # MIN <= X <= MAX

## 문제 해결 부분 ##
n_list = [1] * (MAX - MIN + 1)

for i in range(2, isqrt(MAX) + 1):
    k = i ** 2
    pos = 0 if MIN % k == 0 else k - (MIN % k)
    for j in range(pos, len(n_list), k):
        n_list[j] = 0

print(sum(n_list))
