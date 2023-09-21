from sys import stdin

input = stdin.readline

for _ in range(3):
    n = int(input().strip())

    total = sum([int(input().strip()) for _ in range(n)])
    if total == 0:
        print(0)
    elif total > 0:
        print("+")
    else:
        print("-")
