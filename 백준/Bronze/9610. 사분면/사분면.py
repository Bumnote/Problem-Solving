from sys import stdin

input = stdin.readline

n = int(input().rstrip())
q1, q2, q3, q4, axis = 0, 0, 0, 0, 0
for _ in range(n):
    x, y = map(int, input().split())  # (xi, yi)

    if x > 0:
        # 1 사분면
        if y > 0:
            q1 += 1
        # 4 사분면
        elif y < 0:
            q4 += 1
        # 축
        else:
            axis += 1
    elif x < 0:
        # 2 사분면
        if y > 0:
            q2 += 1
        # 3 사분면
        elif y < 0:
            q3 += 1
        else:
            axis += 1
    else:
        axis += 1

print(f"Q1: {q1}")
print(f"Q2: {q2}")
print(f"Q3: {q3}")
print(f"Q4: {q4}")
print(f"AXIS: {axis}")
