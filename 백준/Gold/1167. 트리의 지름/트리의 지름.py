from sys import stdin
from collections import deque

input = stdin.readline

v = int(input().strip())  # v: 정점의 개수
vertex = [[] for _ in range(v + 1)]

# 정점들의 관계 저장
for _ in range(v):
    info = list(map(int, input().split()))
    v1 = info[0]
    for i in range(1, len(info) - 1, 2):
        v2, w = info[i], info[i + 1]
        vertex[v1].append((v2, w))  # 단방향으로 입력


def bfs(x):
    deq = deque()
    deq.append((x, 0))
    visited = [True] * (v + 1)
    visited[x] = False  # 방문 처리

    dist = -1
    node = -1
    while deq:
        cur_x, cur_dist = deq.popleft()

        if dist < cur_dist:
            dist = cur_dist
            node = cur_x

        for nxt, w in vertex[cur_x]:
            # 방문이 가능하다면 -> append
            if visited[nxt]:
                visited[nxt] = False  # 방문 처리
                deq.append((nxt, cur_dist + w))  # 가중치를 더해간다.

    return dist, node


# 임의의 노드에서 가장 거리가 긴 노드는 트리의 지름을 이루는 두 노드 중 하나이다.
dist, node = bfs(1)
ans, temp = bfs(node)
print(ans)
