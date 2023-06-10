import sys
from collections import deque
n, m = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
ans = 0


def BFS(start):
    visited = [0 for _ in range(n+1)]
    visited[start] = 1
    cnt = 1
    queue = deque()
    queue.append(start)

    while queue:
        v = queue.popleft()
        for j in graph[v]:
            if visited[j] == 0:
                visited[j] = 1
                queue.append(j)
                cnt += 1
    return cnt


for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[b].append(a)

for i in range(1, n+1):
    x = BFS(i)
    if x > ans:
        ans = x
        lst = [i]
    elif x == ans:
        lst.append(i)

print(*lst)