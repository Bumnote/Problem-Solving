from sys import stdin
from collections import deque

input = stdin.readline

N, M, K, X = map(int, input().split())  # N: 도시의 개수, M: 도로의 개수, K: 거리 정보, X: 출발 도시의 번호
vertex = [[] for _ in range(N + 1)]

for _ in range(M):
    A, B = map(int, input().split())
    vertex[A].append(B)  # A -> B: 단방향 그래프


def bfs(X):
    visited = [True] * (N + 1)
    visited[X] = False  # 방문 처리
    deq = deque()
    deq.append((X, 0))

    ans = []

    while deq:
        cur_x, cur_cnt = deq.popleft()

        if cur_cnt == K:
            ans.append(cur_x)

        # 최단 거리보다 커지면 더 이상 탐색할 필요가 없다.
        if cur_cnt > K:
            continue

        for nxt in vertex[cur_x]:
            # 다음 노드에 방문 가능하면 -> append()
            if visited[nxt]:
                visited[nxt] = False  # 방문 처리
                deq.append((nxt, cur_cnt + 1))

    return ans


ans = bfs(X)
if ans:
    print(*sorted(ans), sep="\n")
else:
    print(-1)
