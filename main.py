from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # n x n 행렬
MAP = [list(map(int, input().split())) for _ in range(n)]
dp = [[0] * n for _ in range(n)]  # dp 테이블

## dp 테이블 초기화
dp[0][0] = 1  # 시작 위치

## 문제 해결 부분 ##
for y in range(n):
    for x in range(n):
        # MAP[n - 1][n - 1] 위치에서 종료
        if MAP[y][x] == 0:
            break

        # dp 테이블의 값이 0이 아니라면 -> 문제 상황 진행
        if dp[y][x] != 0:
            jump = MAP[y][x]  # 점프 수
            for dy, dx in ((0, jump), (jump, 0)):
                new_y, new_x = y + dy, x + dx
                # 범위가 벗어나면 -> continue
                if new_y >= n or new_x >= n:
                    continue
                dp[new_y][new_x] += dp[y][x]  # 움직인 위치에 현재 위치의 dp 값을 더해간다.

print(dp[n - 1][n - 1])
