from sys import stdin

input = stdin.readline

while True:
    a, b = map(int, input().split())

    if a == 0 and b == 0:
        break

    diff = a - b
    if diff < 2:
        print(f"{0} {0}")
    elif diff % 2 == 0:
        print(f"{diff // 2} {0}")
    else:
        print(f"{(diff - 3) // 2} {1}")
