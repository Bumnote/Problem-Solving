from sys import stdin
from collections import deque

input = stdin.readline


def bfs(x):
    deq = deque()
    deq.append((0, 0))
    visited[x] = False  # 방문 처리

    while deq:
        cur_x, cur_cnt = deq.popleft()
        if cur_x == n - 1:
            return cur_cnt

        for i in range(1, n_list[cur_x] + 1):
            new_x = cur_x + i
            # 방문이 가능하면 -> deq에 추가
            if 0 <= new_x < n and visited[new_x]:
                deq.append((new_x, cur_cnt + 1))
                visited[new_x] = False  # 방문 처리

    return -1


## 변수 입력 부분 ##
n = int(input().strip())  # 1 x n 미로 (1 <= n <= 1,000)
n_list = list(map(int, input().split()))  # 미로
visited = [True] * n  # 방문 확인용

## 문제 해결 부분 ##
print(bfs(0))

