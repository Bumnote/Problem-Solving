from sys import stdin, setrecursionlimit

setrecursionlimit(10 ** 6)
input = stdin.readline


def dfs(person, step):
    global answer

    visited[person] = True  # 방문 처리
    if person == b:
        answer = step
    for i in graph[person]:
        if not visited[i]:
            dfs(i, step + 1)


vertex = int(input().strip())
a, b = map(int, input().split())
edge = int(input().strip())

graph = [[] for _ in range(vertex + 1)]
visited = [False for _ in range(vertex + 1)]
answer = -1
for _ in range(edge):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

dfs(a, 0)
print(answer)
