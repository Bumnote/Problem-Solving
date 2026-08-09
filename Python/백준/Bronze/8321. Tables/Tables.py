from sys import stdin

input = stdin.readline

n, k, s = map(int, input().split())
lst = sorted(map(int, input().split()), reverse=True)

sum = 0
cnt = 0
target = k * s
for i in range(n):
    sum += lst[i]
    if sum >= target:
        cnt = i + 1
        break

print(cnt)
