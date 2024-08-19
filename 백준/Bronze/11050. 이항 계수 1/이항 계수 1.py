from sys import stdin
from math import comb

input = stdin.readline

n, k = map(int, input().split())

nCk = comb(n, k)
print(nCk)
