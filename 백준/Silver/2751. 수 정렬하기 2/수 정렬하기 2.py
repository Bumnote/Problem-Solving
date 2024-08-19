from sys import stdin

input = stdin.readline

n = int(input().rstrip())

lst = sorted([int(input().rstrip()) for _ in range(n)])
print(*lst, sep='\n')
