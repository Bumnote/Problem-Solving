from sys import stdin
from collections import deque

input = stdin.readline

## 변수 입력 부분 ##
A, B, N, M = map(int, input().split())  # A배, B배, N: 동규 위치, M: 주미 위치

## 문제 해결 부분 ##
visited = [True] * 100001


def in_range(cur_loc):
    return 0 <= cur_loc <= 100000


def bfs(x):
    deq = deque()
    deq.append((x, 0))
    visited[x] = False  # 방문 처리
    while deq:
        cur_x, cur_cnt = deq.popleft()

        # 동규가 주미를 만났다면 -> 최소 이동 거리 return
        if cur_x == M:
            return cur_cnt

        # 이동할 수 있는 8가지 방법 -> 너비 우선 탐색
        for new_x in (cur_x - 1, cur_x + 1, cur_x - A, cur_x + A, cur_x - B, cur_x + B, cur_x * A, cur_x * B):
            # 범위를 넘지 않고, 방문이 가능하면 -> deq에 추가
            if in_range(new_x) and visited[new_x]:
                deq.append((new_x, cur_cnt + 1))
                visited[new_x] = False  # 방문 처리


print(bfs(N))
