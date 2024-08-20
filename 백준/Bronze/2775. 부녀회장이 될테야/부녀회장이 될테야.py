from sys import stdin

input = stdin.readline

# dp 전처리
dp = [[0] * 15 for _ in range(15)]
for i in range(15):
    dp[0][i] = i

for i in range(1, 15):
    for j in range(15):
        dp[i][j] = sum(dp[i - 1][:j + 1])

t = int(input().rstrip())  # t: 테스트 케이스
for _ in range(t):
    # k층 n호
    k = int(input().rstrip())
    n = int(input().rstrip())

    print(dp[k][n])
