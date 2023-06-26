from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())
dp = [0, 1] + [-1] * 89  # dp 테이블 초기화


## 문제 해결 부분 ##
# 재귀 방식을 이용하는 top-down 방식으로 풀이 
def f(n):
    if dp[n] == -1:
        dp[n] = f(n - 1) + f(n - 2)

    return dp[n]


print(f(n))
