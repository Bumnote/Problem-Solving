from sys import stdin
from collections import deque

input = stdin.readline

n = int(input().strip())  # n: 노드의 개수
vertex = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    p, c, w = map(int, input().split())  # p: 부모 노드, c: 자식 노드, w: 가중치
    vertex[p].append((c, w))
    vertex[c].append((p, w))


def bfs(x):
    deq = deque()
    deq.append((x, 0))
    visited = [True] * (n + 1)
    visited[x] = False  # 방문 처리

    node, dist = -1, -1
    while deq:
        cur_x, cur_dist = deq.popleft()
        if dist < cur_dist:
            dist = cur_dist
            node = cur_x
        for nxt, nd in vertex[cur_x]:
            # 방문이 가능하다면 -> append
            if visited[nxt]:
                visited[nxt] = False  # 방문 처리
                deq.append((nxt, cur_dist + nd))

    return node, dist


node, dist = bfs(1)  # 임의의 노드에서 가장 먼 노드를 찾는다.
temp, ans = bfs(node)  # 위에서 찾은 노드는 트리의 지름을 구성하는 두 정점 중 하나이다.
print(ans)
