from sys import stdin
from math import comb

input = stdin.readline

n, k = map(int, input().split())

print(comb(n, k) % 10_007)
