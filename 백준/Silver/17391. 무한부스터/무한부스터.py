from sys import stdin
from collections import deque

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # n x m 행렬
MAP = [list(map(int, input().split())) for _ in range(n)]  # 각 격자마다의 부스터 정보


## 문제 해결 부분 ##
def bfs():
    deq = deque()
    deq.append((0, 0, 0))  # 현재 위치, 현재 격자 개수
    visited = [[True] * m for _ in range(n)]  # 방문 상태
    visited[0][0] = False  # 방문 처리

    while deq:
        cur_y, cur_x, cur_cnt = deq.popleft()
        # 목표 지점에 도달했으면 return
        if cur_y == n - 1 and cur_x == m - 1:
            return cur_cnt

        cur_dist = MAP[cur_y][cur_x]  # 현재 격자의 부스터 정보
        for d in range(cur_dist, 0, -1):
            # 거리가 최대인 것부터 상황을 체크한다.
            for dy, dx in ((0, d), (d, 0)):
                new_y, new_x = cur_y + dy, cur_x + dx
                if new_y < 0 or new_y >= n or new_x < 0 or new_x >= m or not visited[new_y][new_x]:
                    continue
                visited[new_y][new_x] = False  # 방문 처리
                deq.append((new_y, new_x, cur_cnt + 1))


print(bfs())
