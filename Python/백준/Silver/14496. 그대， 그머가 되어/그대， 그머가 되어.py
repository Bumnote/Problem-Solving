from sys import stdin
from collections import deque

input = stdin.readline


def bfs(a, b):
    visited = [False for _ in range(n + 1)]
    visited[a] = True  # 방문 처리
    dq = deque([(a, 0)])

    while dq:

        cur_v, cnt = dq.popleft()

        if cur_v == b:
            return cnt

        for nxt_v in vertex[cur_v]:
            if not visited[nxt_v]:
                visited[nxt_v] = True  # 방문 처리
                dq.append((nxt_v, cnt + 1))

    return -1


a, b = map(int, input().split())
n, m = map(int, input().split())

vertex = [[] for _ in range(n + 1)]
for _ in range(m):
    s, e = map(int, input().split())
    vertex[s].append(e)
    vertex[e].append(s)

print(bfs(a, b))
