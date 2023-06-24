from sys import stdin
from collections import deque

input = stdin.readline

## 변수 입력 부분 ##
n, k = map(int, input().split())  # n x n 행렬, k 이하의 바이러스의 번호
MAP = [list(map(int, input().split())) for _ in range(n)]
s, y, x = map(int, input().split())  # s초 뒤, (y, x)에 존재하는 바이러스의 종류

## 문제 해결 부분 ##
virus = set()
visited = [[True] * n for _ in range(n)]  # 전염 정보
for i in range(n):
    for j in range(n):
        if MAP[i][j] != 0:
            virus.add(MAP[i][j])  # 바이러스의 번호 추가
            visited[i][j] = False  # 전염 처리

flag = deque()  # 전염 위치 저장
# 주어진 시간만큼 반복
while s > 0:
    # 바이러스의 번호를 오름차순으로 전염
    for v_n in sorted(virus):
        for i in range(n):
            for j in range(n):
                # 해당 바이러스의 전염 차례라면
                if MAP[i][j] == v_n:
                    for dy, dx in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                        new_y, new_x = i + dy, j + dx
                        # 범위를 넘거나, 이미 전염이 되었다면 -> continue
                        if new_y < 0 or new_y >= n or new_x < 0 or new_x >= n or not visited[new_y][new_x]:
                            continue
                        visited[new_y][new_x] = False  # 전염 처리
                        flag.append((new_y, new_x, v_n))  # 바이러스 위치 추가

    # 추가된 전염 정보가 없으면, break
    if not flag:
        break

    # 추가된 전염 정보가 있으면, 전염
    while flag:
        i, j, v = flag.popleft()
        MAP[i][j] = v
    s -= 1

print(MAP[y - 1][x - 1])
