from sys import stdin

input = stdin.readline


def find(x):
    if uf[x] == x:
        return x
    uf[x] = find(uf[x])
    return uf[x]


def union(a, b):
    a, b = find(a), find(b)
    uf[a] = b


t = int(input().strip())  # t: 테스트 케이스

for _ in range(t):
    n = int(input().strip())  # n: 노드 수
    m = int(input().strip())  # m: 간선 수

    flag = True
    if n - 1 < m:
        flag = False  # 트리 -> 노드 수 - 1 = 간선 수

    uf = [i for i in range(n + 1)]
    for _ in range(m):
        a, b = map(int, input().split())  # a <-> b: 연결
        # 사이클이 발생한 경우 -> tree가 될 수 없다.
        if find(a) == find(b):
            flag = False
        else:
            union(a, b)

    vertex = [[] for _ in range(n + 1)]
    for j in range(1, n + 1):
        vertex[find(j)].append(j)

    group = 0
    for k in range(1, n + 1):
        # 요소가 존재한다면 -> group 개수 증가
        if vertex[k]:
            group += 1
            # group 개수가 2개 이상이라면 -> graph
            if group > 1:
                flag = False

    if flag:
        print("tree")
    else:
        print("graph")
