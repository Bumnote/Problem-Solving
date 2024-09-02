from sys import stdin

input = stdin.readline

t = int(input().rstrip())

for _ in range(t):
    n = int(input().rstrip())
    lst = [list(map(int, input().split())) for _ in range(2)]
    dp = [[0 for _ in range(n)] for _ in range(2)]

    if n == 1:
        print(max(lst[0][0], lst[1][0]))
    elif n == 2:
        print(max(lst[0][0] + lst[1][1], lst[0][1] + lst[1][0]))
    else:
        # dp 점화식 = max(0행 현재값 + max(1행 직전 항까지의 최댓값, 1행 직전전 항가지의 최댓값), 1행 현재값 + max(0행 직전 항까지의 최댓값, 0행 직전전 항까지의 최댓값))
        dp[0][0], dp[0][1], dp[1][0], dp[1][1] = lst[0][0], lst[0][1] + lst[1][0], lst[1][0], lst[1][1] + lst[0][0]
        for i in range(2, n):
            dp[0][i], dp[1][i] = lst[0][i] + max(dp[1][i - 1], dp[1][i - 2]), lst[1][i] + max(dp[0][i - 1],
                                                                                              dp[0][i - 2])

        print(max(dp[0][n - 1], dp[1][n - 1]))
