from sys import stdin

input = stdin.readline

a, b, c = map(int, input().split())

if a == b and b == c:
    print(10_000 + a * 1_000)
elif a == b:
    print(1_000 + a * 100)
elif b == c:
    print(1_000 + b * 100)
elif c == a:
    print(1_000 + c * 100)
else:
    print(max(a, b, c) * 100)
