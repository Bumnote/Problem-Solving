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


tc = int(input().rstrip())

for t in range(1, tc + 1):
    n = int(input().rstrip())
    k = int(input().rstrip())

    uf = [i for i in range(n)]
    for _ in range(k):
        a, b = map(int, input().split())  # a - b: 친구
        # 두 사람이 친구로 묶이지 않았으면 -> union
        if find(a) != find(b):
            union(a, b)

    m = int(input().rstrip())
    print(f"Scenario {t}:")
    for _ in range(m):
        u, v = map(int, input().split())

        print(1 if find(u) == find(v) else 0)

    print()
