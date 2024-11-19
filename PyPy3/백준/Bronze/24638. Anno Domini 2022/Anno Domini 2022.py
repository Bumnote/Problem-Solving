from sys import stdin

input = stdin.readline

x, y = 0, 0
f = list(input().split())
s = list(input().split())

if f[0] == "AD":
    x = int(f[1]) - 1
else:
    x = -int(f[0])

if s[0] == "AD":
    y = int(s[1]) - 1
else:
    y = -int(s[0])

print(abs(x - y))
