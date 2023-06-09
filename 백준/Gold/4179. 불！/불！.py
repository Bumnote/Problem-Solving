from sys import stdin
from collections import deque

input = stdin.readline


def in_range(y, x):
    return 0 <= y < r and 0 <= x < c


def bfs():
    global fires, jihun

    while jihun:
        j_len = len(jihun)  # 재훈이가 존재할 수 있는 위치의 개수
        f_len = len(fires)  # 불이 존재할 수 있는 위치의 개수

        # 불을 먼저 이동
        for _ in range(f_len):
            f_y, f_x = fires.popleft()  # 1분에 움직일 수 있는 사이클을 모두 탐색한다.

            for dy, dx in ((-1, 0), (1, 0), (0, 1), (0, -1)):
                new_y, new_x = f_y + dy, f_x + dx

                # 범위를 넘거나, 방문한 적이 있거나, 벽이라면 이동 못하므로 -> continue
                if not in_range(new_y, new_x) or not f_visited[new_y][new_x] or miro[new_y][new_x] == "#":
                    continue

                # 범위를 넘지 않고, 방문 가능하고, 빈 칸이라면 -> fires에 추가
                fires.append((new_y, new_x))
                f_visited[new_y][new_x] = False  # 움직인 위치 방문 처리
                miro[new_y][new_x] = "F"  # 불 표시

        # 그 다음, 지훈이 이동
        for _ in range(j_len):
            j_y, j_x, j_c = jihun.popleft()  # 1분에 움직일 수 있는 사이클을 모두 탐색한다.

            for dy, dx in ((-1, 0), (1, 0), (0, 1), (0, -1)):
                new_y, new_x = j_y + dy, j_x + dx
                # 만약 재훈이가 미로의 경로를 벗어난다면 -> 탈출 가능한 경우이므로, 움직인 거리를 return
                if not in_range(new_y, new_x):
                    return j_c + 1

                # 방문한 적이 있고, 빈 칸이 아니라면 -> continue
                if not j_visited[new_y][new_x] or miro[new_y][new_x] != ".":
                    continue

                # 방문한 적이 없고, 빈 칸이라면 -> 이동
                jihun.append((new_y, new_x, j_c + 1))
                j_visited[new_y][new_x] = False  # 움직인 위치는 방문 처리

    # jihun이가 더 이상 움직일 수 없게 되면, 탈출 불가능
    return "IMPOSSIBLE"


## 변수 입력 부분 ##
r, c = map(int, input().split())  # 1 <= r, c <= 1000, r: 행, c: 열
miro = []  # 미로 맵
jihun = deque()
fires = deque()

j_visited = [[True] * c for _ in range(r)]  # 지훈이의 방문 확인 리스트
f_visited = [[True] * c for _ in range(r)]  # 불의 방문 확인 리스트

for y in range(r):
    miro.append(list(input().strip()))
    for x in range(c):
        # 지훈이의 위치 저장
        if miro[y][x] == "J":
            jihun.append((y, x, 0))
            j_visited[y][x] = False  # 방문 처리
        # 불의 위치 저장
        if miro[y][x] == "F":
            f_visited[y][x] = False  # 방문 처리
            fires.append((y, x))

## 문제 해결 부분 ##
print(bfs())
