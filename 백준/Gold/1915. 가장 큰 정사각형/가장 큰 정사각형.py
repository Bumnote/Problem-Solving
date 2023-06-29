from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # n x m MAP
MAP = [list(map(int, input().strip())) for _ in range(n)]  # 숫자 정보
ans = 0
# DP 테이블 초기화 -> 0행, 0열인 부분에 대해서만 초기화
dp = [[0] * m for _ in range(n)]  # DP 테이블
for r in range(n):
    if MAP[r][0] == 1:
        dp[r][0] = 1
        ans = 1
for c in range(m):
    if MAP[0][c] == 1:
        dp[0][c] = 1
        ans = 1

## 문제 풀이 부분 ##
for y in range(1, n):
    for x in range(1, m):
        if MAP[y][x] == 1:
            dp[y][x] = min(dp[y - 1][x], dp[y][x - 1], dp[y - 1][x - 1]) + 1
            if dp[y][x] > ans:
                ans = dp[y][x]

print(ans ** 2)
