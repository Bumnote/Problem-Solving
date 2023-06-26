from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n, k = map(int, input().split())  # nCk % 10007

## dp 초기화 과정
dp = []
for i in range(1, n + 2):
    dp.append([-1] * i)

for i in range(n + 1):
    for j in range(len(dp[i])):
        if i == j or j == 0:
            dp[i][j] = 1


## 문제 해결 부분 ##
def tri(n, k):
    # 조합의 성질 활용
    if dp[n][k] == -1:
        dp[n][k] = tri(n - 1, k) + tri(n - 1, k - 1)

    return dp[n][k]


print(tri(n, k) % 10007)
