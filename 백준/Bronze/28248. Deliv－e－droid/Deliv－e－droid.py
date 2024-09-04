from sys import stdin

input = stdin.readline

p = int(input().rstrip())
c = int(input().rstrip())

if p > c:
    print(p * 50 - 10 * c + 500)
else:
    print(p * 50 - c * 10)
