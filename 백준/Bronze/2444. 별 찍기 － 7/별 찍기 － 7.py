from sys import stdin

input = stdin.readline

n = int(input().rstrip())

for i in range(n):
    print(" " * (n - i - 1), end="")
    print("*" * (2 * i + 1), end="")
    print()

for i in range(1, n):
    print(" " * i, end="")
    print("*" * (2 * (n - i - 1) + 1), end="")
    print()
