from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
tc = int(input().strip())  # 테스트 케이스

## 문제 해결 부분 ##
for _ in range(tc):
    dp = [1, 2, 4]  # dp 초기화
    n = int(input().strip())  # 1 <= n < 11
    for i in range(n - 3):
        next = dp[i] + dp[i + 1] + dp[i + 2]  # dp 점화식
        dp.append(next)  # dp 리스트에 append

    print(dp[n - 1])
