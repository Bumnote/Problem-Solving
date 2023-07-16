from sys import stdin

input = stdin.readline

n = int(input().strip())
dp = [0] * (n + 1)

# dp 테이블 구현
for i in range(2, n + 1):
    dp[i] = dp[i - 1] + 1
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i // 3] + 1)

    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i // 2] + 1)

print(dp[n])  # 최소 연산값 출력

# dp 테이블 역추적
n_list = [n]
while n != 1:
    if (n % 3 == 0) and (dp[n // 3] == dp[n] - 1):
        n //= 3
        n_list.append(n)
        continue
    if (n % 2 == 0) and (dp[n // 2] == dp[n] - 1):
        n //= 2
        n_list.append(n)
        continue

    n -= 1
    n_list.append(n)

print(*n_list)  # 이동한 경로 출력
