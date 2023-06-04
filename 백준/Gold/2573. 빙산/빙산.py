from sys import stdin
from collections import deque

input = stdin.readline


# DFS(= 깊이 우선 탐색)는 재귀적으로 동작하여, 호출 스택이 쌓여 메모리를 많이 잡아먹는다.
# BFS(= 너비 우선 탐색)는 덱에 데이터를 삽입하는 메모리만 잡아먹는다.
def bfs(y, x):
    deq.append((y, x))  # 덱에 현재 상황을 append 한다.
    visited[y][x] = False  # 방문 처리

    # 덱의 모든 원소가 없어질 때까지 -> 연결된 요소 모두 탐색
    while deq:
        cur_y, cur_x = deq.popleft()
        for dy, dx in zip(dys, dxs):
            new_y, new_x = cur_y + dy, cur_x + dx
            # 방문이 가능한 곳이라면 -> 덱에 append
            if visited[new_y][new_x]:
                deq.append((new_y, new_x))
                visited[new_y][new_x] = False  # 방문 처리


## 변수 입력 부분 ##
n, m = map(int, input().split())
# 배열의 가장자리 부분은 모두 0이기 때문에, 범위는 신경쓰지 않아도 된다.
iceberg = [list(map(int, input().split())) for _ in range(n)]  # 빙산의 현재 상태
blank = [[0] * m for _ in range(n)]  # 동, 서, 남, 북에 위치한 0의 개수
dys, dxs = [1, -1, 0, 0], [0, 0, 1, -1]  # 동, 서, 남, 북
day = 0

## 문제 해결 부분 ##
# 두 덩어리 이상으로 나누어질 때까지 반복한다.
deq = deque([])
while True:
    day += 1  # while문에 들어올 때마다 하루씩 증가
    ice_cnt = 0  # 빙하 그룹의 개수 & 계속 초기화
    visited = [[False] * m for _ in range(n)]  # 방문 상태 & 계속 초기화

    ## 바닷물의 개수(= 0의 개수)를 세는 과정 ##
    for y in range(n):
        for x in range(m):
            if iceberg[y][x]:
                # 높이가 0이 아닌 빙하에 대해서만 동, 서, 남, 북 탐색
                for dy, dx in zip(dys, dxs):
                    new_y, new_x = y + dy, x + dx
                    if iceberg[new_y][new_x] == 0:
                        blank[y][x] += 1  # 현재 빙하의 위치에서 동, 서, 남, 북 0(= 바닷물)의 개수를 저장한다.

    ## 바닷물에 의해 녹은 결과 구현 과정 ##
    for y in range(n):
        for x in range(m):
            # 현재 빙하의 높이는 주변 바닷물의 개수만큼 감소한 높이, 최솟값이 0이므로 0과 비교
            iceberg[y][x] = max(0, iceberg[y][x] - blank[y][x])
            blank[y][x] = 0  # 빼준 다음에는 다시 0으로 초기화 해준다.
            # 녹은 뒤에도 빙하가 남아 있다면 접근이 가능하다.
            if iceberg[y][x] != 0:
                visited[y][x] = True  # 빙하의 높이가 존재하는 부분은 방문 가능

    ## 빙산 그룹의 개수를 세는 과정 ##
    for y in range(n):
        for x in range(m):
            if visited[y][x]:
                bfs(y, x)
                ice_cnt += 1

    # 빙산이 모두 녹아버렸다면, 0을 출력한다. 
    if ice_cnt == 0:
        print(0)
        break
    
    # 2 덩어리 이상 나오게 된다면, 해당 소모된 날을 출력한다.
    if ice_cnt >= 2:
        print(f"{day}")
        break
