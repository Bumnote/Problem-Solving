from sys import stdin
from math import sqrt

input = stdin.readline

A, B = map(int, input().split())  # x^2 + 2Ax + B = 0

det = sqrt((2 * A) ** 2 - 4 * B) # 판별식
x1, x2 = (-2 * A - det) / 2, (-2 * A + det) / 2
# 중근인 경우 
if x1 == x2:
    print(f"{int(x1)}")
# 중근이 아닌 경우 
else:
    print(f"{int(x1)} {int(x2)}")
