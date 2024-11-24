from sys import stdin

input = stdin.readline

n = int(input().rstrip())
print("SK" if n % 2 == 0 else "CY")
