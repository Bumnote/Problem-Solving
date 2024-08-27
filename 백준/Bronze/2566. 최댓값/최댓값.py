from sys import stdin

input = stdin.readline

lst = []
MAX = -1
r, c = None, None
for i in range(9):
    lst.append(list(map(int, input().split())))
    for j in range(9):
        if MAX < lst[i][j]:
            MAX = lst[i][j]
            r, c = i + 1, j + 1
print(MAX)
print(f"{r} {c}")
