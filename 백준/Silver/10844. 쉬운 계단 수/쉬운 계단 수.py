from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # n 자리의 계단 수
MOD = 1_000_000_000

## dp 테이블 초기화
dp = [[-1] * 10 for _ in range(101)]
for i in range(0, 10):
    if i == 0:
        dp[1][i] = 0
    else:
        dp[1][i] = 1  # f(1, 0) = 0 / 나머지 f(1, i) = 1


## 문제 해결 부분 ##
def f(n, d):
    if dp[n][d] == -1:
        # 끝 자리가 0 이면 그 전의 숫자는 1일 수 밖에 없다.
        if d == 0:
            dp[n][d] = f(n - 1, d + 1)
        # 끝 자리가 9 이면 그 전의 숫자는 8일 수 밖에 없다.
        elif d == 9:
            dp[n][d] = f(n - 1, d - 1)
        else:
            dp[n][d] = f(n - 1, d - 1) + f(n - 1, d + 1)

    return dp[n][d]


ans = 0
for i in range(10):
    ans += f(n, i)

print(ans % MOD)
