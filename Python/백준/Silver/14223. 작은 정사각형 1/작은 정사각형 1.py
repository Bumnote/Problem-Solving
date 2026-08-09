from sys import stdin
from itertools import combinations

input = stdin.readline

n = int(input().rstrip())

points = []
for _ in range(n):
    x, y = map(int, input().split())
    points.append((x, y))

MIN = float('inf')
dys, dxs = [-1, 1, 0, 0], [0, 0, -1, 1]
for comb in combinations(points, n - 2):
    l, r, u, d = float('inf'), -float('inf'), float('inf'), -float('inf')
    for x, y in comb:
        for dy, dx in zip(dys, dxs):
            ny, nx = x + dy, y + dy
            l = min(l, nx)
            r = max(r, nx)
            u = min(u, ny)
            d = max(d, ny)

    area_1 = (r - l) ** 2
    area_2 = (d - u) ** 2
    area = max(area_1, area_2)
    MIN = min(MIN, area)

print(MIN)
