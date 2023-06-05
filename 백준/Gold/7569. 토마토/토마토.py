from sys import stdin
from collections import deque

input = stdin.readline



def in_range(t, y, x):
    return (0 <= t < h) and (0 <= y < n) and (0 <= x < m)

def push(t, y, x, dist):
    deq.append((t, y, x, dist)) # 큐에 다음 탐색할 부분을 insert
    visited[t][y][x] = False # 방문 처리
    distance[t][y][x] = dist # 움직인 거리 저장
    boxes[t][y][x] = 1 # 익은 것으로 처리

# dfs(높이, 행, 열, 거리)
# 이 코드는 토마토를 하나씩 bfs를 돌리고 있습니다. 모든 토마토를 동시에 bfs를 돌려야 최소 시간을 구할 수 있습니다. ==> 틀린 이유
def bfs():
    while deq:
        t, y, x, dist = deq.popleft()

        for dt, dy, dx in zip(dts, dys, dxs):
            new_t, new_y, new_x = t + dt, y + dy, x+ dx
            # 범위를 넘어서지 않고, 방문한 적이 없고, 익지 않은 토마토라면 탐색을 진행한다.
            if in_range(new_t, new_y, new_x) and visited[new_t][new_y][new_x] and boxes[new_t][new_y][new_x] == 0:
                push(new_t, new_y, new_x, dist + 1)

def print_answer():
    max_distance = 0 # 토마토가 다 익는 데 걸리는 최소 날짜를 담을 변수이다.
    for t in range(h):
        for y in range(n):
            for x in range(m):
                # 익지 않은 토마토가 있다면, 바로 -1을 반환하고, 함수를 종료시킨다.
                if boxes[t][y][x] == 0:
                    return -1
                max_distance = max(max_distance, distance[t][y][x])
    # for 문을 탈출했다는 것은 익지 않은 토마토가 없다는 뜻으로, 최장 거리를 반환하고 함수를 종료시킨다.
    return max_distance

## 변수 입력 부분 ##
m, n, h = map(int, input().split())  # n: 행, m: 열, h: 높이

boxes = [[list(map(int, input().split())) for _ in range(n)] for _ in range(h)]
visited = [[[True] * m for _ in range(n)] for _ in range(h)]
distance = [[[-1] * m for _ in range(n)] for _ in range(h)]
deq = deque()
# 상단, 하단, 동, 서, 남, 북 / 0번째 높이가 가장 아래 층을 뜻한다.
dts, dys, dxs = [1, -1, 0, 0, 0, 0], [0, 0, 1, -1, 0, 0], [0, 0, 0, 0, 1, -1]
# 익은 토마토, 익지 않은 토마토, 토마토가 없는 곳
ripe_tomato, unripe_tomato, non_tomato = 0, 0, 0

for t in range(h):
    for y in range(n):
        for x in range(m):
            if boxes[t][y][x] == 0:
                unripe_tomato += 1
            if boxes[t][y][x] == 1:
                ripe_tomato += 1
            if boxes[t][y][x] == -1:
                non_tomato += 1
                visited[t][y][x] = False  # 토마토가 없는 것은 방문할 수 없다.

## 문제 해결 부분 ##
# 이미 모든 토마토가 익어있는 상태 -> 0 출력
if (non_tomato + ripe_tomato) == h*n*m:
    print(0)
else:
    # 탐색 시작
    for t in range(h):
        for y in range(n):
            for x in range(m):
                # 방문한 적이 없고, 익은 토마토가 있다면, 그래프 탐색(= bfs) 시작
                if visited[t][y][x] and boxes[t][y][x] == 1:
                    push(t,y,x,0)

    bfs() # 매개변수가 따로 필요없다.

    # 탐색 종료 후
    print(print_answer())

"""
5 3 1
0 -1 0 0 0
-1 -1 0 1 1
0 0 0 1 1

5 3 2
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 1 0 0
0 0 0 0 0

4 3 2
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
-1 -1 -1 -1
1 1 1 -1
"""
