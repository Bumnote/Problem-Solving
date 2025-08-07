from collections import deque


def bfs(x):
    dq = deque([x])
    visited = [False] * (n + 1)
    visited[x] = True

    cnt = 1
    while dq:
        curr = dq.popleft()
        for nxt in lst[curr]:
            if not visited[nxt]:
                visited[nxt] = True
                dq.append(nxt)
                cnt += 1

    return cnt


n, m = map(int, input().split())
lst = [[] for _ in range(n + 1)]

ans = []
for _ in range(m):
    a, b = map(int, input().split())
    # a가 b를 신뢰하면 b -> a 접근이 가능하다.
    lst[b].append(a)

MAX = -1
for i in range(1, n + 1):
    cnt = bfs(i)
    if MAX < cnt:
        ans = [i]
        MAX = cnt
    elif MAX == cnt:
        ans.append(i)

print(*ans)
