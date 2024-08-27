from sys import stdin

input = stdin.readline

t = int(input().rstrip())

for tc in range(1, t + 1):
    a, b = map(int, input().split())
    print(f"Case #{tc}: {a + b}")
