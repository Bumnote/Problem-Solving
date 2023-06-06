from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # n: 삼각형의 크기  (1 <= n <= 500)
tri = [list(map(int, input().split())) for _ in range(n)]  # 정수 삼각형
dp = [[0] * i for i in range(1, n + 1)]  # dp를 위한 리스트
answer = 0

## 문제 해결 부분 ##
dp[0][0] = tri[0][0]  # 초기값 설정
for y in range(1, n):
    for x in range(y + 1):
        # 0열에 대한 셋팅
        if x == 0:
            dp[y][x] = tri[y][x] + dp[y - 1][x]
        # 대각선 방향에 대한 셋팅
        elif y == x:
            dp[y][x] = tri[y][x] + dp[y - 1][x - 1]
        # 0열도 아니고, 대각선 방향도 아닌 성분에 대한 셋팅
        else:
            dp[y][x] = max(tri[y][x] + dp[y - 1][x], tri[y][x] + dp[y - 1][x - 1])

# 최댓값 구하기 -> dp의 마지막 행에 대해서 최댓값 찾기
for t in range(n):
    answer = max(answer, dp[n - 1][t])

print(f"{answer}")
