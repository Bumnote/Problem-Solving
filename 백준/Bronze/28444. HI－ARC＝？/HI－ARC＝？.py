from sys import stdin

input = stdin.readline

h, i, a, r, c = map(int, input().split())

print(f"{h * i - a * r * c}")
