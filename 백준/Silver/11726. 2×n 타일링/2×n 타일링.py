from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # 2 x n 타일링
MOD = 10_007

## dp 초기화
dp = [1, 2] + [0] * 999
for i in range(2, n + 1):
    dp[i] = dp[i - 1] + dp[i - 2]
    dp[i] %= MOD

print(dp[n - 1])
