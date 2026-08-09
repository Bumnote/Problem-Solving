from sys import stdin
from collections import deque

input = stdin.readline


def bfs(x):
    visited = [False for _ in range(f + 1)]
    visited[x] = True

    dq = deque([(x, 0)])
    while dq:
        cur_x, cnt = dq.popleft()

        if cur_x == g:
            return cnt

        for nxt_x in [cur_x + u, cur_x - d]:
            if 1 <= nxt_x <= f and not visited[nxt_x]:
                visited[nxt_x] = True  # 방문 처리
                dq.append((nxt_x, cnt + 1))

    return -1


"""
f: f층 (1 ~ f층)
s: 강호 위치 
g: 스타트링크 위치
u: 위로 
d: 아래로  
"""
f, s, g, u, d = map(int, input().split())
ans = bfs(s)
print(ans if ans != -1 else "use the stairs")
