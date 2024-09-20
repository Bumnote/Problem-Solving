from sys import stdin

input = stdin.readline

n = int(input().rstrip())

detector = []
for _ in range(n):
    detector.append(input().rstrip())

for i in range(n - 2, -1, -1):
    if detector[i + 1] == "TRUTH":
        continue
    else:
        detector[i] = "TRUTH" if detector[i] == "LIE" else "LIE"

print(detector[0])
