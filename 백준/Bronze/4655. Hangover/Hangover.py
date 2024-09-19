from sys import stdin

input = stdin.readline

while True:
    n = float(input().rstrip())

    if n == 0.00:
        break

    total = 0.0
    num = 2
    while total < n:
        total += (1 / num)
        num += 1

    print(f"{num - 2} card(s)")
