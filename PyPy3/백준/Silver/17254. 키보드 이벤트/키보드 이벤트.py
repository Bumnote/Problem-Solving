from sys import stdin

input = stdin.readline

n, m = map(int, input().split())

keyboard = []
for _ in range(m):
    a, b, c = input().split()  # a번 키보드, b초에 문자 c
    keyboard.append([int(a), int(b), c])

ans = ""
for a, b, c in sorted(keyboard, key=lambda x: (x[1], x[0])):
    ans += c

print(ans)
