from sys import stdin
from collections import deque

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # n: 정점, m: 간선 (n <= 10,000 / m <= 10,000)
vertex = [[] for _ in range(n + 1)]
for _ in range(m):
    A, B = map(int, input().split())  # A -> B 신뢰: B 해킹 -> A 해킹 (단방향)
    vertex[B].append(A)


## 문제 해결 부분 ##
def bfs(x):
    global cnt
    deq = deque()
    deq.append(x)
    visited[x] = False  # 방문 처리

    while deq:
        cur_x = deq.popleft()

        for elem in vertex[cur_x]:
            # 방문이 가능하다면 -> deq에 추가 & 해킹 가능 횟수 증가
            if visited[elem]:
                visited[elem] = False  # 방문 처리
                deq.append(elem)
                cnt += 1


max_hack = 0
hack_lst = []
for i in range(1, n + 1):
    visited = [True] * (n + 1)
    cnt = 0

    bfs(i)  # 너비 우선 탐색 실행

    if max_hack < cnt:
        hack_lst = [i]
        max_hack = cnt  # 최대 해킹 가능 횟수 갱신

    # 최대 해킹 가능 횟수가 같으면 hack_lst에 계속 추가
    elif max_hack == cnt:
        hack_lst.append(i)

## 정답 출력 부분 ##
print(*hack_lst)
