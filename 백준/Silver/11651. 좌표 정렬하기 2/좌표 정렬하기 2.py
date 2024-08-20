from sys import stdin

input = stdin.readline

n = int(input().rstrip())

lst = []
for _ in range(n):
    x, y = map(int, input().split())
    lst.append((x, y))

for xi, yi in sorted(lst, key=lambda x: (x[1], x[0])):
    print(f"{xi} {yi}")
