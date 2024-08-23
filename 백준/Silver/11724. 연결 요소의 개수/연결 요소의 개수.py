from sys import stdin, setrecursionlimit

setrecursionlimit(10 ** 3)
input = stdin.readline


def dfs(cur_v):
    for nxt_v in vertex[cur_v]:
        if canVisit[nxt_v]:
            canVisit[nxt_v] = False  # 방문 처리
            dfs(nxt_v)


n, m = map(int, input().split())

vertex = [[] for _ in range(n + 1)]
canVisit = [True for _ in range(n + 1)]
for _ in range(m):
    u, v = map(int, input().split())
    vertex[u].append(v)
    vertex[v].append(u)

cnt = 0
for node in range(1, n + 1):
    if canVisit[node]:
        canVisit[node] = False  # 방문 처리
        cnt += 1
        dfs(node)

print(cnt)
