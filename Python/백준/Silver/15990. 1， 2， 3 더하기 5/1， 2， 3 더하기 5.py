from sys import stdin

input = stdin.readline

LEN = 100_000
MOD = 1_000_000_009
# dp[i][j] -> 숫자 i를 만들기 위한 방법 중 마지막 더한 숫자가 j인 경우의 수
dp = [[0] * 4 for _ in range(LEN + 1)]
# i == 1 인 경우
dp[1][1] = 1
# i == 2 인 경우
dp[2][2] = 1
# i == 3 인 경우
dp[3][1], dp[3][2], dp[3][3] = 1, 1, 1

for i in range(4, LEN + 1):
    dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD
    dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD
    dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD

t = int(input().rstrip())
for _ in range(t):
    n = int(input().rstrip())
    print(sum(dp[n]) % MOD)
