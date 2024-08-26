from sys import stdin
from itertools import combinations

input = stdin.readline


def get_dist(y1, x1, y2, x2):
    return abs(y2 - y1) + abs(x2 - x1)


n, m = map(int, input().split())  # n x n MAP, m: 치킨집의 개수
MAP = []

homes = []
chicken = []
for i in range(n):
    MAP.append(list(map(int, input().split())))
    for j in range(n):
        if MAP[i][j] == 1:
            homes.append((i, j))  # 집의 위치 저장
        elif MAP[i][j] == 2:
            chicken.append((i, j))  # 치킨의 위치 저장

ans = int(1e9)
for comb in combinations(chicken, m):
    total = 0
    for hy, hx in homes:
        dist = int(1e9)
        for cy, cx in comb:
            dist = min(dist, get_dist(hy, hx, cy, cx))  # 집에 대한 치킨 거리를 구한다.

        total += dist  # 각 집에 대한 치킨 거리를 구한다.

    ans = min(ans, total)  # 도시의 치킨 거리가 가장 짧은 거리를 저장한다.

print(ans)
