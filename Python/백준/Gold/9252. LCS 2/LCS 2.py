from sys import stdin

input = stdin.readline


def get_text(r, c):
    if r == 0 or c == 0:
        return

    # 두 문자가 같은 경우
    if A[r - 1] == B[c - 1]:
        path.append(A[r - 1])
        get_text(r - 1, c - 1)
    # 두 문자가 다른 경우
    else:
        if dp[r - 1][c] > dp[r][c - 1]:
            get_text(r - 1, c)
        else:
            get_text(r, c - 1)


A = input().rstrip()
B = input().rstrip()

# dp 초기화
dp = [[0 for _ in range(len(B) + 1)] for _ in range(len(A) + 1)]
path = []

# dp[i][j] = A 문자열 i 번째와 B 문자열 j 번째까지 LCS
for i in range(1, len(A) + 1):
    for j in range(1, len(B) + 1):
        if A[i - 1] == B[j - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

get_text(len(A), len(B))

# 정답 출력
print(dp[len(A)][len(B)])
print(*path[::-1], sep='')
