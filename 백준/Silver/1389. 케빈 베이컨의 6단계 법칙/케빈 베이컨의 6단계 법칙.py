from sys import stdin
from collections import deque

input = stdin.readline


def bfs(x):
    canVisit = [True for _ in range(n + 1)]
    canVisit[x] = False  # 방문 처리

    dq = deque([(x, 0)])
    total = 0
    while dq:
        cur_x, cnt = dq.popleft()
        total += cnt
        for nxt_x in vertex[cur_x]:
            if canVisit[nxt_x]:
                canVisit[nxt_x] = False  # 방문처리
                dq.append((nxt_x, cnt + 1))

    return total


n, m = map(int, input().split())

vertex = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    vertex[a].append(b)
    vertex[b].append(a)

MIN = int(1e9)
idx = 0
for i in range(1, n + 1):
    SUM = bfs(i)
    if MIN > SUM:
        MIN = SUM
        idx = i

print(idx)
