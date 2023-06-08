from sys import stdin
from collections import deque

input = stdin.readline


def bfs(x):
    deq = deque()
    deq.append((x, 0))  # (현재 위치, 방문 거리)
    visited[x] = False  # 방문 처리

    while deq:
        cur_x, cur_cnt = deq.popleft()
        distance[cur_x] = cur_cnt  # 방문 거리 저장

        for next in range(n):
            # 방문 가능하고, 연결되어있다면 -> deq에 추가
            if visited[next] and vertex[cur_x][next] == 1:
                deq.append((next, cur_cnt + 1))
                visited[next] = False  # 방문 처리


## 변수 입력 부분 ##
n, m = map(int, input().split())  # n: 도시의 개수, m: 도로의 개수
vertex = [[0] * n for _ in range(n)]

for _ in range(m):
    v1, v2 = map(int, input().split())  # v1 <--> v2 양방향
    v1, v2 = v1 - 1, v2 - 1  # 인덱스 변경
    vertex[v1][v2] = 1
    vertex[v2][v1] = 1

q = int(input().strip())  # q: 도로 정비 계획인 도로의 수
for _ in range(q):
    a, i, j = map(int, input().split())  #
    i, j = i - 1, j - 1  # 인덱스 변경
    # a == 1: 두 도시를 잇는다.
    if a == 1:
        vertex[i][j] = 1
        vertex[j][i] = 1
    # a == 2: 두 도시를 끊는다.
    else:
        vertex[i][j] = 0
        vertex[j][i] = 0

    ## 문제 해결 부분 ##
    visited = [True] * n
    distance = [-1] * n
    bfs(0)
    print(*distance, sep=" ")
