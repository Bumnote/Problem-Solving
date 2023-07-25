from sys import stdin

input = stdin.readline

s_list = list(input().strip())

print("".join(sorted(s_list, reverse=True)))
