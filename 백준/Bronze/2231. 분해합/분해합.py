from sys import stdin

input = stdin.readline

n = int(input().rstrip())

answer = 0
for i in range(1, n + 1):
    const = i + sum([int(v) for v in str(i)])
    if const == n:
        answer = i
        break

print(answer)
