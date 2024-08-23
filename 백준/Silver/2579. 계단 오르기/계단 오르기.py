from sys import stdin

input = stdin.readline

n = int(input().rstrip())
stairs = [0] + [int(input().rstrip()) for _ in range(n)]

dp = [0 for _ in range(n + 1)]
# 계단이 1개 뿐인 경우 
if n == 1:
    dp[1] = stairs[1]
    print(dp[n])
# 계단이 2개 이상인 경우 
else:
    dp[1], dp[2] = stairs[1], stairs[1] + stairs[2]
    for i in range(3, n + 1):
        # 점화식 구현
        dp[i] = max(dp[i - 3] + stairs[i - 1] + stairs[i], dp[i - 2] + stairs[i])

    print(dp[n])
