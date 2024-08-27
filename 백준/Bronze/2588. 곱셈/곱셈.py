from sys import stdin

input = stdin.readline

a = int(input().rstrip())
b = input().rstrip()

for i in b[::-1]:
    print(a * int(i))

print(a * int(b))
