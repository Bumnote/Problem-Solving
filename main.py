from sys import stdin
from collections import deque

input = stdin.readline


def bfs(x):
    deq = deque()
    deq.append((x, 0))  # (현재 위치, 떨어진 거리)
    visited[x] = False  # 방문 처리

    while deq:
        cur_x, cur_cnt = deq.popleft()
        distance[cur_x] = cur_cnt  # 현재 위치에 현재 거리를 저장한다.

        for elem in vertex[cur_x]:
            # 방문이 가능하다면 -> deq에 추가
            if visited[elem]:
                visited[elem] = False  # 방문 처리
                deq.append((elem, cur_cnt + 1))


## 변수 입력 부분 ##
n, m = map(int, input().split())  # n: 도시의 개수, m: 도로의 개수
vertex = [[] for _ in range(n + 1)]
visited = [True] * (n + 1)
distance = [-1] * (n + 1)

for _ in range(m):
    v1, v2 = map(int, input().split())  # v1 <--> v2: 양방향 그래프
    vertex[v1].append(v2)
    vertex[v2].append(v1)

q = int(input().strip())  # q: 도로 정비 계획인 도로의 수

for _ in range(q):
    i, j = map(int, input().split())
    vertex[i].append(j)
    vertex[j].append(i)
    ## 문제 해결 부분 ##
    visited = [True] * (n + 1)
    distance = [-1] * (n + 1)
    bfs(1)
    print(*distance[1:], sep=" ")
