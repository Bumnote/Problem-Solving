from sys import stdin
from collections import deque

N, M, V = map(int, input().split())  # N: 정점의 개수, M: 간선의 개수, V: 시작 정점
vertex = [[] for _ in range(N + 1)]

for _ in range(M):
    v1, v2 = map(int, input().split())  # v1 <-> v2
    vertex[v1].append(v2)
    vertex[v2].append(v1)

# 낮은 정점부터 방문하기 위해서 오름차순 정렬
for i in range(1, N + 1):
    vertex[i].sort()


def dfs(V):
    visited[V] = False  # 방문 처리
    print(V, end=" ")
    for nxt in vertex[V]:
        # 방문이 가능하다면 -> dfs 탐색
        if visited[nxt]:
            visited[nxt] = False  # 방문 처리
            dfs(nxt)


def bfs(V):
    deq = deque()
    deq.append(V)
    visited = [True] * (N + 1)
    visited[V] = False  # 방문처리

    while deq:
        cur_v = deq.popleft()
        print(cur_v, end=" ")
        for nxt in vertex[cur_v]:
            # 방문이 가능하다면 -> append
            if visited[nxt]:
                visited[nxt] = False  # 방문 처리
                deq.append(nxt)


visited = [True] * (N + 1)
dfs(V)
print()
bfs(V)
