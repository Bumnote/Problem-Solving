from sys import stdin

input = stdin.readline

n = int(input().rstrip())
# (r, g, b) 순서로 비용이
homes = [list(map(int, input().split())) for _ in range(n)]
dp = [[0] * 3 for _ in range(n)]

# dp 초기값 설정
for i in range(3):
    dp[0][i] = homes[0][i]

for i in range(1, n):
    # 이전에 R을 색칠한 경우
    dp[i][0] = min(dp[i - 1][1] + homes[i][0], dp[i - 1][2] + homes[i][0])
    # 이전에 G를 색칠한 경우
    dp[i][1] = min(dp[i - 1][0] + homes[i][1], dp[i - 1][2] + homes[i][1])
    # 이전에 B를 색칠한 경우
    dp[i][2] = min(dp[i - 1][0] + homes[i][2], dp[i - 1][1] + homes[i][2])

print(min(dp[n - 1]))
