from sys import stdin

input = stdin.readline

n = int(input().rstrip())

lst = []
for _ in range(n):
    xi, yi = map(int, input().split())
    lst.append((xi, yi))

for a, b in sorted(lst, key=lambda x: (x[0], x[1])):
    print(f"{a} {b}")
