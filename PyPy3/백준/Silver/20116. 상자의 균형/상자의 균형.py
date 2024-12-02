from sys import stdin

input = stdin.readline

n, l = map(int, input().split())
x_lst = list(map(int, input().split()))
dp = [0 for _ in range(n)]
dp[-1] = x_lst[-1]

for i in range(n - 1, 0, -1):
    dp[i - 1] = dp[i] + x_lst[i - 1]

flag = True
cnt = 1
for i in range(n - 1, 0, -1):
    if x_lst[i - 1] - l < dp[i] / cnt < x_lst[i - 1] + l:
        cnt += 1
        continue
    else:
        flag = False
        break

print("stable" if flag else "unstable")
