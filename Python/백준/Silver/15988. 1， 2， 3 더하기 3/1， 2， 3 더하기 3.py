from sys import stdin

input = stdin.readline

LEN = 1_000_000
MOD = 1_000_000_009
# dp 초기화 
dp = [0 for _ in range(LEN + 1)]
dp[1], dp[2], dp[3] = 1, 2, 4
for i in range(4, LEN + 1):
    dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % MOD

t = int(input().rstrip())

for _ in range(t):
    n = int(input().rstrip())
    print(dp[n])
