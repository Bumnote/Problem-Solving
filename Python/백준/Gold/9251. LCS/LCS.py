from sys import stdin

input = stdin.readline

A = input().rstrip()
B = input().rstrip()

# dp 초기화
dp = [[0 for _ in range(len(B) + 1)] for _ in range(len(A) + 1)]

# dp[i][j] = A 문자열 i 번째와 B 문자열 j 번째까지 LCS
for i in range(1, len(A) + 1):
    for j in range(1, len(B) + 1):
        if A[i - 1] == B[j - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

# 정답 출력
print(dp[len(A)][len(B)])
