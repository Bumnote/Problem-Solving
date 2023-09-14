from sys import stdin

input = stdin.readline


def find(x):
    # 자기 자신이 대표노드라면 -> 자기 자신을 반환한다.
    if uf[x] == x:
        return x

    uf[x] = find(uf[x])
    return uf[x]


def union(a, b):
    a, b = find(a), find(b)  # 각각의 노드의 대표 노드를 구한다.
    uf[a] = b  # a의 대표노드를 b의 대표노드와 연결(a -> b)한다.


tc = int(input().strip())  # tc: 테스트 케이스

for t in range(1, tc + 1):
    n = int(input().strip())  # n: 유저의 수
    k = int(input().strip())  # k: 관계의 수
    uf = [i for i in range(n + 1)]  # union-find list

    for _ in range(k):
        a, b = map(int, input().split())  # a <-> b: 친구 관계
        union(a, b)

    print(f"Scenario {t}:")
    m = int(input().strip())  # m: 질의 수
    for _ in range(m):
        u, v = map(int, input().split())  # u <-> v: 경로가 있는가?

        # 서로 연결되어 있다면 -> 1 출력
        if find(u) == find(v):
            print(1)
        # 서로 연결되어 있지 않다면 -> 0 출력
        else:
            print(0)

    print()
