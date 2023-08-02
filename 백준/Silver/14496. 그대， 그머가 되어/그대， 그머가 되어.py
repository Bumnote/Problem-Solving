from sys import stdin
from collections import deque

input = stdin.readline

a, b = map(int, input().split())  # a -> b
N, M = map(int, input().split())  # N: 문자의 수, M: 치환 가능 문자쌍
vertex = [[] for _ in range(N + 1)]
for _ in range(M):
    s, e = map(int, input().split())  # s <-> e: 양방향 그래프
    vertex[s].append(e)
    vertex[e].append(s)


def bfs(a, b):
    visited = [True] * (N + 1)
    visited[a] = False  # 방문 처리
    dq = deque()
    dq.append((a, 0))

    while dq:
        cur_x, cur_cnt = dq.popleft()

        # a를 b로 치환한 경우 -> 최소 횟수 반환
        if cur_x == b:
            return cur_cnt

        for nxt in vertex[cur_x]:
            if visited[nxt]:
                visited[nxt] = False  # 방문 처리
                dq.append((nxt, cur_cnt + 1))

    # 치환이 불가능한 경우
    return -1


print(bfs(a, b))
