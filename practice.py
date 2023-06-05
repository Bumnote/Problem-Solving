from sys import stdin
from collections import deque

input = stdin.readline


def bfs(a, k):
    deq = deque()
    deq.append((a, 0))  # (현재 숫자, 횟수)
    visited = [True] * 1000001

    while deq:
        cur_a, cur_cnt = deq.popleft()
        # 정수 a가 k가 되었다면 -> 횟수 return
        if cur_a == k:
            return cur_cnt
        visited[cur_a] = False  # 중복 허용을 위해 여기서 방문처리
        for dx in (1, cur_a):
            new_a = cur_a + dx
            # 범위를 넘지 않고, 방문 가능하면 -> deq에 추가
            if 1 <= new_a <= 1000000 and visited[new_a]:
                deq.append((new_a, cur_cnt + 1))

    return -1


## 변수 입력 부분 ##
a, k = map(int, input().split())  # A 를 K로 만들기

## 문제 해결 부분 ##
print(bfs(a, k))
