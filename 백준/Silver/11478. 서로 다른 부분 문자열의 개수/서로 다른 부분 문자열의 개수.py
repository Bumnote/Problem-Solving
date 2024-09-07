from sys import stdin

input = stdin.readline

st = input().rstrip()

s = set()
for i in range(len(st)):
    for j in range(len(st) - i + 1):
        s.add(st[j:j + i])

print(len(s))
