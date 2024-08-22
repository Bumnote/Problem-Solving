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

    uf[y_root] = x_root  # 작은 정점을 대표 노드로 설정


while True:
    m, n = map(int, input().split())

    # 입력 종료 조건
    if m == 0 and n == 0:
        break
    # 정점 수가 많은 상황이므로, 크루스칼 알고리즘 구현
    uf = [i for i in range(m + 1)]
    edges = []
    total = 0
    for _ in range(n):
        x, y, z = map(int, input().split())
        edges.append((z, x, y))
        total += z  # 가로등이 모두 켜져있는 상황에 드는 비용의 합

    edges.sort()  # 가중치를 기준으로 오름차순 정렬

    SUM = 0
    for cost, x, y in edges:
        if find(x) != find(y):
            union(x, y)
            SUM += cost  # 최소 비용의 합을 구한다.

    print(total - SUM)
