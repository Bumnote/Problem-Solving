from sys import stdin

input = stdin.readline

tc = int(input().rstrip())

for _ in range(tc):
    a, b = map(int, input().split())
    if a < b:
        print("NO BRAINS")
    else:
        print("MMM BRAINS")
