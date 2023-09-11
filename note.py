from sys import stdin
from collections import deque

input = stdin.readline


# 첫번째 코인의 범위를 확인하는 함수
def check_first_coin(y, x):
    return y < 0 or y >= n or x < 0 or x >= m


# 두번재 코인의 범위를 확인하는 함수
def check_second_coin(y, x):
    return y < 0 or y >= n or x < 0 or x >= m


# 너비우선탐색(= bfs) 함수
def bfs(y0, x0, y1, x1):
    visited = [[[True, True] for _ in range(m)] for _ in range(n)]
    visited[y0][x0][0] = False  # 방문처리
    visited[y1][x1][1] = False  # 방문처리
    dq = deque()
    dq.append((y0, x0, y1, x1, 0))

    while dq:
        cy_0, cx_0, cy_1, cx_1, cur_cnt = dq.popleft()

        # 순서: 왼쪽, 오른쪽, 위, 아래
        for dy, dx in ((0, -1), (0, 1), (-1, 0), (1, 0)):
            ny_0, nx_0, ny_1, nx_1 = cy_0 + dy, cx_0 + dx, cy_1 + dy, cx_1 + dx
            # 두 코인이 모두 나간 경우 -> 신경쓰지 않는다.
            if check_first_coin(ny_0, nx_0) and check_second_coin(ny_1, nx_1):
                print(F"모두 나간 경우 -> {ny_0} {nx_0} {ny_1} {nx_1}")
                print(f"{check_first_coin(ny_0, nx_0)} {check_second_coin(ny_1, nx_1)}")
                continue
            # 두 코인 중 하나만 나간 경우 -> 움직인 횟수를 반환한다.
            elif check_first_coin(ny_0, nx_0) ^ check_second_coin(ny_1, nx_1):
                print(f"하나만 나간 경우 -> {ny_0} {nx_0} {ny_1} {nx_1}")
                return cur_cnt + 1

            # 두 코인 모두 범위를 벗어나지 않는 경우 -> 계속 탐색
            else:
                # 첫번째 코인의 경우 -> 벽이거나, 방문 불가능 하다면 멈춰있는다.
                if MAP[ny_0][nx_0] == "#" and not visited[ny_0][nx_0][0]:
                    ny_0, nx_0 = cy_0, cx_0  # 원래 자리에 멈춰있는다.

                # 두번째 코인의 경우
                if MAP[ny_1][nx_1] == "#" and not visited[ny_1][nx_1][1]:
                    ny_1, nx_1 = cy_1, cx_1

                dq.append((ny_0, nx_0, ny_1, nx_1, cur_cnt + 1))

    return -1


n, m = map(int, input().split())  # n x m MAP

MAP = []
coins = []
for i in range(n):
    MAP.append(list(input().strip()))
    for j in range(m):
        if MAP[i][j] == "o":
            coins.append((i, j))

print(coins)
# 버튼 -> 왼쪽, 오른쪽, 위, 아래
y0, x0, y1, x1 = *coins[0], *coins[1]
print(f"y0 = {y0} / x0 = {x0} / y1 = {y1} / x1 = {x1}")
res = bfs(y0, x0, y1, x1)

print(f"res = {res}")

print(res if res <= 10 else -1)

"""
[
  [[True, True], [True, True], [True, True]], 
  [[True, True], [True, True], [True, True]], 
  [[True, True], [True, True], [True, True]], 
  [[True, True], [True, True], [True, True]], 
  [[True, True], [True, True], [True, True]]
]
"""
