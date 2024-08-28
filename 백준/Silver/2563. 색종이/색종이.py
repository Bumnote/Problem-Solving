from sys import stdin

input = stdin.readline

n = int(input().rstrip())  # n: 색종이의 수
paper = [[0 for _ in range(101)] for _ in range(101)]

for _ in range(n):
    x, y = map(int, input().split())
    for i in range(y, y + 10):
        for j in range(x, x + 10):
            paper[i][j] = 1

area = 0
for i in range(1, 101):
    for j in range(1, 101):
        if paper[i][j] == 1:
            area += 1

print(area)
