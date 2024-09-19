from sys import stdin

input = stdin.readline

n, c = input().split()

s = set()
cnt, new_person = 0, 0
for _ in range(int(n)):
    need = None
    if c == "Y":
        need = 1
    elif c == "F":
        need = 2
    else:
        need = 3

    name = input().rstrip()
    if name not in s:
        s.add(name)
        new_person += 1

    if new_person == need:
        cnt += 1
        new_person = 0

print(cnt)
