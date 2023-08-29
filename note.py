from sys import stdin

input = stdin.readline

n = int(input().strip())  # n!

ans = 1
for i in range(1, n + 1):
    ans *= i

print(ans)
