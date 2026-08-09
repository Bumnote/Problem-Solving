from sys import stdin

input = stdin.readline

lst = list(map(int, input().split()))
ans = sum([elem * 5 for elem in lst])
print(ans)
