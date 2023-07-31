from sys import stdin
from collections import deque

input = stdin.readline

N = int(input().strip())  # N: 노드의 개수
vertex = [[] for _ in range(N + 1)]
for _ in range(N - 1):
    v1, v2 = map(int, input().split())  # v1 <-> v2: 양방향 그래프
    vertex[v1].append(v2)
    vertex[v2].append(v1)


def bfs(node):
    visited[node] = 0
    dq = deque()
    dq.append(node)  # 루트 노드 저장 

    while dq:
        cur_node = dq.popleft()

        for nxt_node in vertex[cur_node]:
            # 아직 방문한 적이 없다면 -> 현재 노드가 곧 다음 노드의 부모 노드가 된다.
            if visited[nxt_node] == -1:
                visited[nxt_node] = cur_node  # 다음 노드에 부모 노드 저장
                dq.append(nxt_node)
    return


visited = [-1] * (N + 1)
bfs(1)

print(*visited[2:], sep="\n")
