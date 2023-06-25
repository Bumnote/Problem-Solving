from sys import stdin
from collections import deque

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # n x m MAP
MAP = [list(map(int, input().split())) for _ in range(n)]  # 치즈 정보
melting = []


## 문제 해결 부분 ##
def bfs(y, x):
    deq = deque()
    deq.append((y, x))
    visited[y][x] = False  # 방문 처리

    while deq:
        cur_y, cur_x = deq.popleft()  # 현재 위치

        for dy, dx in ((-1, 0), (1, 0), (0, 1), (0, -1)):
            new_y, new_x = cur_y + dy, cur_x + dx
            # 범위를 넘거나, 방문한 적이 있다면 -> continue
            if new_y < 0 or new_y >= n or new_x < 0 or new_x >= m or not visited[new_y][new_x]:
                continue

            # 현재 위치에서 치즈를 탐색 -> 외곽 접촉의 개수
            if MAP[new_y][new_x] != 0:
                temp[new_y][new_x] += 1
                # 외부와의 마찰이 2곳 이상이면
                if temp[new_y][new_x] >= 2:
                    melting.append((new_y, new_x))
            else:
                visited[new_y][new_x] = False  # 방문 처리
                deq.append((new_y, new_x))


cnt = 0
while True:
    melting = []  # 녹을 치즈 정보 저장
    temp = [[0] * m for _ in range(n)]  # 접촉되는 외부 격자의 개수 정보
    visited = [[True] * m for _ in range(n)]  # 방문 정보
    bfs(0, 0)

    # 녹을 치즈가 없다면 -> break
    if not melting:
        print(cnt)
        break
        # 녹을 치즈가 있다면 -> melting 작업
    else:
        for m_y, m_x in melting:
            MAP[m_y][m_x] = 0

    cnt += 1
