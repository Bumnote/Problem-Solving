from sys import stdin

input = stdin.readline

n, m = map(int, input().split())
a = int(input().rstrip())
b = int(input().rstrip())

print(a * b)
