from sys import stdin
from collections import deque

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # 1 <= n <= 10^6


## 문제 해결 부분 ##
def bfs(n):
    visited = [True] * 1000001  # 1 <= n <= 10^6
    visited[n] = False  # 방문 처리
    deq = deque()
    deq.append((n, 0))  # (현재 위치, 연산 횟수)

    while deq:
        cur_loc, cur_cnt = deq.popleft()

        if cur_loc == 1:
            return cur_cnt

        if cur_loc % 3 == 0 and visited[cur_loc // 3]:
            visited[cur_loc // 3] = False
            deq.append((cur_loc // 3, cur_cnt + 1))

        if cur_loc % 2 == 0 and visited[cur_loc // 2]:
            visited[cur_loc // 2] == False
            deq.append((cur_loc // 2, cur_cnt + 1))

        if visited[cur_loc - 1]:
            visited[cur_loc - 1] = False
            deq.append((cur_loc - 1, cur_cnt + 1))


print(bfs(n))
