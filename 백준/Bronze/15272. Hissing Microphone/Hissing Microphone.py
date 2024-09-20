from sys import stdin

input = stdin.readline

s = input().rstrip()
if "ss" not in s:
    print("no hiss")
else:
    print("hiss")
