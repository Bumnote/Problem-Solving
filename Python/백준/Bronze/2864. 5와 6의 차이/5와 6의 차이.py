from sys import stdin

input = stdin.readline

a, b = input().split()

MAX = int(a.replace("5", "6")) + int(b.replace("5", "6"))
MIN = int(a.replace("6", "5")) + int(b.replace("6", "5"))

print(f"{MIN} {MAX}")
