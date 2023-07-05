from sys import stdin
from collections import deque

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # n: 선분의 수
vertex = [[] for _ in range(n + 1)]

lines = [0] + [tuple(map(int, input().split())) for _ in range(n)]

for i in range(1, n):
    for j in range(i + 1, n + 1):
        if lines[j][1] < lines[i][0] or lines[i][1] < lines[j][0]:
            continue
        # 가중치 = 1
        vertex[i].append(j)
        vertex[j].append(i)

q = int(input().strip())


def bfs(start, end):
    deq = deque()
    deq.append((start, 0))
    visited = [True] * (n + 1)
    visited[start] = False  # 방문 처리
    while deq:
        cur_x, cur_cnt = deq.popleft()
        if cur_x == end:
            return cur_cnt

        for nxt in vertex[cur_x]:
            # 방문이 가능하다면 -> append
            if visited[nxt]:
                visited[nxt] = False  # 방문 처리
                deq.append((nxt, cur_cnt + 1))

    return -1


# q: 질문의 수
for _ in range(q):
    A, B = map(int, input().split())  # 두 선분의 번호
    print(bfs(A, B))
