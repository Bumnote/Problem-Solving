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


def get_dist(y1, x1, y2, x2):
    return abs(y1 - y2) + abs(x2 - x1)


t = int(input().strip())

for _ in range(t):
    n = int(input().rstrip())

    lst = []
    edges = []

    for _ in range(n + 2):
        y, x = map(int, input().split())
        lst.append((y, x))

    uf = [i for i in range(n + 3)]
    for i in range(n + 1):
        for j in range(i + 1, n + 2):
            dist = get_dist(*lst[i], *lst[j])
            if dist > 1_000:
                continue
            edges.append((dist, i + 1, j + 1))

    cnt = 0
    edges.sort()  # 거리 순으로 오름차순 정렬
    for cost, a, b in edges:
        if find(a) != find(b):
            union(a, b)  # 같은 집합으로 묶는다.
            cnt += 1
        else:
            continue

    print("happy" if find(1) == find(n + 2) else "sad")
