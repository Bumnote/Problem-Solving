from sys import stdin
from collections import deque

input = stdin.readline


def bfs(a, b):
    visited = [True] * (n + 1)
    visited[a] = False  # 시작점 방문 처리
    dq = deque()
    dq.append((a, 0))

    while dq:
        cur_v, cur_cnt = dq.popleft()
        if cur_v == b:
            return cur_cnt

        i = 1
        # 양의 방향
        while True:
            nxt_v = cur_v + n_list[cur_v] * i
            i += 1
            # 범위를 벗어난 경우 -> 탐색 중지
            if nxt_v > n:
                break
            # 방문이 가능하다면 -> 탐색 요소로 추가
            if visited[nxt_v]:
                visited[nxt_v] = False  # 방문 처리
                dq.append((nxt_v, cur_cnt + 1))

        j = 1
        # 음의 방향
        while True:
            nxt_v = cur_v - n_list[cur_v] * j
            j += 1
            # 범위를 벗어난 경우 -> 탐색 중지
            if nxt_v < 1:
                break
            # 방문이 가능하다면 -> 탐색 요소로 추가
            if visited[nxt_v]:
                visited[nxt_v] = False
                dq.append((nxt_v, cur_cnt + 1))

    return -1


n = int(input().strip())  # n: 징검다리의 개수
n_list = [0] + list(map(int, input().split()))
a, b = map(int, input().split())  # a -> b

print(bfs(a, b))
