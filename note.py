from sys import stdin

input = stdin.readline

n, m = map(int, input().split())  # n: 정점의 개수, m: 간선의 개수
vertex = [[] for _ in range(n + 1)]
for _ in range(m):
    u, v = map(int, input().split())  # u <-> v: 무방향 그래프(= 양방향)
    vertex[u].append(v)
    vertex[v].append(u)

visited = [True] * (n + 1)


def dfs(x):
    visited[x] = False  # 방문 처리

    for nxt in vertex[x]:
        if visited[nxt]:
            dfs(nxt)


cnt = 0
for i in range(1, n + 1):
    if visited[i]:
        dfs(i)
        cnt += 1

print(cnt)
