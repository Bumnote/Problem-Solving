from sys import stdin
from collections import deque

input = stdin.readline


def bfs(cur_v):
    dq = deque([(cur_v, 1)])

    while dq:

        cur_v, color = dq.popleft()

        for nxt_v in vertex[cur_v]:
            # 방문한 적이 없는 경우
            if visited[nxt_v] == 0:
                dq.append((nxt_v, color * -1))
                visited[nxt_v] = color * -1
            # 방문한 적이 있는 경우
            elif visited[nxt_v] + color != 0:
                return False

    return True


k = int(input().rstrip())

for _ in range(k):

    v, e = map(int, input().split())

    vertex = [[] for _ in range(v + 1)]
    visited = [0 for _ in range(v + 1)]
    for _ in range(e):
        v1, v2 = map(int, input().split())
        vertex[v1].append(v2)
        vertex[v2].append(v1)

    ans = True
    for i in range(1, v + 1):
        if visited[i] == 0:
            visited[i] = 1
            flag = bfs(i)

            if not flag:
                ans = False
                break

    print("YES" if ans else "NO")
