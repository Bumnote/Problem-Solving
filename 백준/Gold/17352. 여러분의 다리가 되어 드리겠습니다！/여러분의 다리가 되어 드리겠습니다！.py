from sys import stdin, setrecursionlimit

setrecursionlimit(3 * (10 ** 5))
input = stdin.readline


def find(x):
    if uf[x] == x:
        return x

    uf[x] = find(uf[x])
    return uf[x]


def union(a, b):
    a, b = find(a), find(b)
    uf[a] = b


n = int(input().strip())  # n: 섬의 개수
uf = [i for i in range(n + 1)]
islands = [[] for _ in range(n + 1)]

# 대표 정점들끼리 연결
for _ in range(n - 2):
    u, v = map(int, input().split())  # u <-> v: 연결
    union(u, v)

# 대표 정점과 연결된 노드들을 저장
for i in range(1, n + 1):
    islands[find(i)].append(i)

ans = []
for j in range(1, n + 1):
    # 원소가 있는 집합이라면 -> 원소 하나만 저장
    if islands[j]:
        ans.append(islands[j][0])

print(*ans)
