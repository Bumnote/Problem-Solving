from sys import stdin
from math import comb

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # nCm

## 문제 풀이 부분 ##
print(comb(n, m))
