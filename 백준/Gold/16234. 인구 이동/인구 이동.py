from sys import stdin
from collections import deque

input = stdin.readline

## 변수 입력 부분 ##
n, l, r = map(int, input().split())  # n x n 행렬, l명 이상, r명 이하
grid = [list(map(int, input().split())) for _ in range(n)]  # 인구 정보


## 문제 해결 부분 ##
def bfs(y, x):
    global cnt, total
    deq = deque()
    deq.append((y, x))
    border[y][x] = True # 국경 처리
    city.append((y, x))
    while deq:
        cur_y, cur_x = deq.popleft()

        for dy, dx in ((-1, 0), (1, 0), (0, 1), (0, -1)):
            new_y, new_x = cur_y + dy, cur_x + dx
            # 범위를 넘거나, 국경처리를 한 경우 -> continue
            if new_y < 0 or new_y >= n or new_x < 0 or new_x >= n or border[new_y][new_x]:
                continue

            # l명 이상 r명 이하가 아닌 경우 -> continue
            diff = abs(grid[new_y][new_x] - grid[cur_y][cur_x])
            if diff < l or diff > r:
                continue
            border[new_y][new_x] = True
            cnt += 1  # 도시 추가
            total += grid[new_y][new_x]  # 인구 수 증가
            city.append((new_y, new_x))  # 연합인 도시의 좌표를 추가
            deq.append((new_y, new_x))


day = 0
while True:
    flag = True  # 하루가 시작됨에 따라 flag 초기화
    border = [[False] * n for _ in range(n)]  # 방문 확인
    for y in range(n):
        for x in range(n):
            # 국경체크를 하지 않았다면 -> 탐색 시작
            if not border[y][x]:
                cnt = 1
                total = grid[y][x]
                city = deque()
                bfs(y, x)

                if len(city) >= 2:
                    flag = False

                while city:
                    n_y, n_x = city.popleft()
                    grid[n_y][n_x] = total // cnt


    if flag:
        print(day)
        break

    day += 1
