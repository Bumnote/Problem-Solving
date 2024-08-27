from sys import stdin

input = stdin.readline

n = int(input().rstrip())
print(sum([i for i in range(1, n + 1)]))
