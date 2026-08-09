from sys import stdin

input = stdin.readline

# 씨앗에서 피어날 수 있는 꽃의 종류
n = int(input().rstrip())

ans = 0
for N in range(n, 0, -1):
    ans += (n / N)

print(ans)