from sys import stdin, setrecursionlimit

setrecursionlimit(10 ** 5)
input = stdin.readline


# 대표 노드를 찾아 반환하는 함수
def find(x):
    if uf[x] == x:
        return x

    uf[x] = find(uf[x])
    return uf[x]


# 두 노드를 연결하는 함수
def union(a, b):
    a, b = find(a), find(b)
    uf[a] = b


n, m = map(int, input().split())  # n: 0 ~ n 범위, m: 연산의 개수
uf = [i for i in range(n + 1)]

for _ in range(m):
    command, a, b = map(int, input().split())  # command: 연산의 종류

    # 정점 a와 정점 b를 연결한다
    if command == 0:
        union(a, b)  # b의 대표 정점을 a로 결정한다.
    # 정점 a와 정점 b가 같은 집합에 포함되어 있는지를 확인한다.
    else:
        # 같은 집합에 속한다면 -> "YES" 출력
        if find(a) == find(b):
            print("YES")
        # 같은 집합에 속하지 않는다면 -> "NO" 출력
        else:
            print("NO")
