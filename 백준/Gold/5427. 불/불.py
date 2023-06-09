from sys import stdin
from collections import deque

input = stdin.readline


def in_range(y, x):
    return 0 <= y < h and 0 <= x < w


def bfs():
    global person, fires

    # 상근이의 위치가 더 이상 추가가 안될 때까지
    while person:
        p_len = len(person)
        f_len = len(fires)

        # 불 먼저 이동
        for _ in range(f_len):
            f_y, f_x = fires.popleft()
            for dy, dx in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                new_y, new_x = f_y + dy, f_x + dx
                # 범위를 넘거나, 방문한 적이 있거나, 벽일 경우 -> continue
                if not in_range(new_y, new_x) or not f_visited[new_y][new_x] or buildings[new_y][new_x] == "#":
                    continue
                fires.append((new_y, new_x))
                f_visited[new_y][new_x] = False  # 방문 처리
                buildings[new_y][new_x] = "*"  # 불 퍼짐 처리

        # 상근이 이동
        for _ in range(p_len):
            p_y, p_x, p_cnt = person.popleft()
            for dy, dx in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                new_y, new_x = p_y + dy, p_x + dx
                # 다음 위치가 빌딩 밖을 벗어나면 -> 움직인 거리 return
                if not in_range(new_y, new_x):
                    return p_cnt + 1

                # 방문한 적이 있거나, 빈 칸이 아니라면 -> continue
                if not p_visited[new_y][new_x] or buildings[new_y][new_x] != ".":
                    continue

                person.append((new_y, new_x, p_cnt + 1))
                p_visited[new_y][new_x] = False  # 방문 처리

    return "IMPOSSIBLE"


tc = int(input().strip())  # 테스트 케이스 개수

for _ in range(tc):
    w, h = map(int, input().split())  # w: 너비, h: 높이 (1 <= w, h <= 1,000)
    buildings = []
    person = deque()
    fires = deque()
    p_visited = [[True] * w for _ in range(h)]  # 상근이의 방문 확인 리스트
    f_visited = [[True] * w for _ in range(h)]  # 불의 방문 확인 리스트

    for y in range(h):
        ## 변수 입력 부분 ##
        buildings.append(list(input().strip()))
        for x in range(w):
            if buildings[y][x] == "@":
                person.append((y, x, 0))
                p_visited[y][x] = False  # 방문 처리
            if buildings[y][x] == "*":
                fires.append((y, x))
                f_visited[y][x] = False  # 방문 처리

    ## 문제 해결 부분 ##
    print(bfs())
