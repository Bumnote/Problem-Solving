from sys import stdin
from math import sqrt

input = stdin.readline


def find(x):
    if uf[x] != x:
        uf[x] = find(uf[x])
    return uf[x]


def union(x, y):
    x_root, y_root = find(x), find(y)

    # 대표 노드가 같다면 -> return
    if x_root == y_root:
        return

    if x_root > y_root:
        x_root, y_root = y_root, x_root

    uf[y_root] = x_root  # 수가 더 작은 노드를 대표 노드로 설정


def get_dist(y1, x1, y2, x2):
    return sqrt((y2 - y1) ** 2 + (x2 - x1) ** 2)


n, m = map(int, input().split())  # n: 우주신들의 개수, m: 통로의 개수

# 이미 연결된 지점이 많을 수 있으므로 -> 크루스칼 알고리즘 활용
uf = [i for i in range(n + 1)]
points = [0 for _ in range(n + 1)]
for i in range(1, n + 1):
    x, y = map(int, input().split())  # x <-> y: 우주신들의 좌표
    points[i] = (x, y)

edges = []
for i in range(1, n + 1):
    for j in range(i + 1, n + 1):
        dist = get_dist(*points[i], *points[j])
        edges.append((dist, i, j))

edges.sort()  # 거리를 기준으로 오름차순 정렬

for _ in range(m):
    x, y = map(int, input().split())  # x <-> y: 이미 입력된 통로
    # 두 노드를 연결
    if find(x) != find(y):
        union(x, y)

total = 0
for cost, a, b in edges:
    # 두 노드의 대표 노드가 다르다면 -> 하나로 연결
    if find(a) != find(b):
        total += cost
        union(a, b)

print(f"{total:.2f}")
