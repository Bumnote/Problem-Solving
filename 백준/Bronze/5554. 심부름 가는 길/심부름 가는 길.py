from sys import stdin

input = stdin.readline

total = sum([int(input().rstrip()) for _ in range(4)])

minute = total // 60
second = total % 60
print(f"{minute}\n{second}")
