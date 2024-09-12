from sys import stdin

input = stdin.readline

n = int(input().rstrip())

names = {}
for _ in range(n):
    s = input().rstrip()[0]
    if s not in names:
        names[s] = 1
    else:
        names[s] += 1

ans = ""
for ch, cnt in sorted(names.items(), key=lambda x: (x[0])):
    if cnt >= 5:
        ans += ch

print(ans if len(ans) >= 1 else "PREDAJA")
