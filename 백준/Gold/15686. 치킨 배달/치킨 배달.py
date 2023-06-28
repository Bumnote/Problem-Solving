from sys import stdin, maxsize
from itertools import combinations

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # n x n 행렬, m: 치킨집의 개수
grid = []
chicken = []
home = []
for y in range(n):
    grid.append(list(map(int, input().split())))
    for x in range(n):
        # 치킨집이라면 -> 치킨 위치를 저장
        if grid[y][x] == 2:
            chicken.append((y, x))
        # 집이라면 -> 집 위치를 저장
        elif grid[y][x] == 1:
            home.append((y, x))

## 문제 해결 부분 ##
min_total = maxsize
for c in combinations(chicken, m):
    c_total = 0
    for h_y, h_x in home:
        min_dist = maxsize
        for c_y, c_x in c:
            c_dist = abs(h_y - c_y) + abs(h_x - c_x)
            min_dist = min(min_dist, c_dist)
        c_total += min_dist

    min_total = min(min_total, c_total)

print(min_total)
