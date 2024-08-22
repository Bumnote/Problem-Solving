from sys import stdin
from math import sqrt

input = stdin.readline

n = int(input().rstrip())

for _ in range(n):
    binary = list(map(int, input().rstrip()))
    total = 0

    for i in range(23, -1, -1):
        total += (binary[i] * 2 ** (23 - i))

    print(total)
