from sys import stdin

input = stdin.readline

print(sum([int(input().rstrip()) for _ in range(5)]))
