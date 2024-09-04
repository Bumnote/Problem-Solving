from sys import stdin

input = stdin.readline

w, h = map(int, input().split())

rec = w + h
diag = (w ** 2 + h ** 2) ** (1 / 2)
print(rec - diag)
