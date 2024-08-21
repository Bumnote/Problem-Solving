from sys import stdin
from collections import deque

input = stdin.readline


def bfs(x):
    MAX = 100_001
    canVisit = [True for _ in range(MAX)]
    canVisit[x] = False  # 수빈이 위치 방문 처리

    dq = deque([(x, 0)])
    while dq:
        cur_x, cnt = dq.popleft()

        if cur_x == k:
            return cnt

        for nxt_x in [cur_x - 1, cur_x + 1, 2 * cur_x]:
            # 범위를 넘지 않고, 방문이 가능하다면 -> append
            if 0 <= nxt_x < MAX and canVisit[nxt_x]:
                canVisit[nxt_x] = False  # 방문 처리
                dq.append((nxt_x, cnt + 1))

    return -1


n, k = map(int, input().split())
print(bfs(n))
