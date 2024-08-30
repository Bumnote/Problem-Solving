from sys import stdin

input = stdin.readline


def find(x):
    if uf[x] != x:
        uf[x] = find(uf[x])
    return uf[x]


def union(x, y):
    x_root, y_root = find(x), find(y)

    if x_root == y_root:
        return

    if x_root > y_root:
        x_root, y_root = y_root, x_root

    uf[y_root] = x_root


n = int(input().rstrip())  # n: 행성의 개수
planet = []

# kruskal 알고리즘 활용
uf = [i for i in range(n)]
edges = []
for i in range(n):
    planet.append(list(map(int, input().split())))
    for j in range(n):
        if planet[i][j] != 0:
            edges.append((planet[i][j], i, j))

edges.sort()  # 비용을 기준으로 오름차순 정렬
total = 0
for cost, a, b in edges:
    # 같은 집합이 아니라면 -> union
    if find(a) != find(b):
        union(a, b)
        total += cost

print(total)
