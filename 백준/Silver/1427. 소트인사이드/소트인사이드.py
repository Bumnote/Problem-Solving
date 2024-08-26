from sys import stdin

input = stdin.readline

lst = list(input().rstrip())

print("".join(sorted(lst, reverse=True)))
