from sys import stdin

input = stdin.readline


def get_xy(a, b, c, d, e, f):
    for x in range(-999, 1000):
        for y in range(-999, 1000):
            if a * x + b * y == c and d * x + e * y == f:
                return x, y


def get_x(t, p):
    for x in range(-999, 1000):
        if t * x == p:
            return x

    return -1, -1


"""
ax + by = c
dx + ey = f
"""
a, b, c, d, e, f = map(int, input().split())

x, y = get_xy(a, b, c, d, e, f)
print(f"{x} {y}")
