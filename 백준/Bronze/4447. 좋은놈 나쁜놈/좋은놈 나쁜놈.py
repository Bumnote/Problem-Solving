from sys import stdin

input = stdin.readline

n = int(input().rstrip())

for _ in range(n):
    name = input().strip()
    g, b = name.count('g') + name.count('G'), name.count('b') + name.count('B')
    if g > b:
        print(f"{name} is GOOD")
    elif g < b:
        print(f"{name} is A BADDY")
    else:
        print(f"{name} is NEUTRAL")
