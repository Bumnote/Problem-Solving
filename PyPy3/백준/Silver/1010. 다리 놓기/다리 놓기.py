from sys import stdin
from math import comb

input = stdin.readline

t = int(input().rstrip())

for _ in range(t):
    n, m = map(int, input().split())
    print(comb(m, n))
