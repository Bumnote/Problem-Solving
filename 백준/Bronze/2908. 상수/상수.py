from sys import stdin

input = stdin.readline

a, b = input().split()
x, y = int(a[::-1]), int(b[::-1])

print(x if x > y else y)
