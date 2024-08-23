from sys import stdin, setrecursionlimit

setrecursionlimit(10 ** 5)
input = stdin.readline


def dfs(cur_v):
    for nxt_v in vertex[cur_v]:
        if canVisit[nxt_v]:
            canVisit[nxt_v] = False  # 방문 처리
            parent[nxt_v] = cur_v  # 다음 노드의 부모 노드는 현재 노드
            dfs(nxt_v)


n = int(input().rstrip())

vertex = [[] for _ in range(n + 1)]
parent = [1 for _ in range(n + 1)]
canVisit = [True for _ in range(n + 1)]
for _ in range(n - 1):
    v1, v2 = map(int, input().split())
    vertex[v1].append(v2)
    vertex[v2].append(v1)

canVisit[1] = False  # 루트 노드 방문 처리
dfs(1)

print(*parent[2:], sep='\n')
