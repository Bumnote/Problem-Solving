from sys import stdin

input = stdin.readline

n = int(input().rstrip())
dist = list(map(int, input().split()))

# dp[i] = i번 위치까지 올 수 있는 최소 횟수
INF = float('inf')
dp = [INF for _ in range(n)]
dp[0] = 0  # 초기화
for i in range(n):
    for j in range(1, dist[i] + 1):
        nxt_v = i + j
        # 범위를 넘지 않는 경우
        if nxt_v < n:
            dp[nxt_v] = min(dp[i] + 1, dp[nxt_v])

print(dp[n - 1] if dp[n - 1] != INF else -1)
