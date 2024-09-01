from sys import stdin

input = stdin.readline

e, f, c = map(int, input().split())

bottle = 0
e = e + f
while e >= c:
    bottle += e // c
    e = (e % c) + (e // c)

print(bottle)
