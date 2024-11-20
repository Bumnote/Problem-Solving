from sys import stdin
from math import isqrt

input = stdin.readline

n, w, h = map(int, input().split())
MAX = isqrt(w ** 2 + h ** 2)
for _ in range(n):
    length = int(input().rstrip())
    print("YES" if length <= MAX else "NO")
