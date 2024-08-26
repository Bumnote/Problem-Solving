from sys import stdin

input = stdin.readline

n = int(input().rstrip())
lst = [int(input().rstrip()) for _ in range(n)]
print(*sorted(lst), sep='\n')
