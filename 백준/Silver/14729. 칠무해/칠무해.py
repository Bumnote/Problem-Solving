from sys import stdin

input = stdin.readline

n = int(input().rstrip())

scores = sorted([float(input().rstrip()) for _ in range(n)])

for score in scores[:7]:
    print(f"{score:.3f}")
