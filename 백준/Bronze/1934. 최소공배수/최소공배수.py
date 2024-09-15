from sys import stdin

input = stdin.readline


def get_gcd(a, b):
    if a < b:
        a, b = b, a
    while b:
        a, b = b, a % b

    return a


def get_lcm(a, b):
    return a * b // get_gcd(a, b)


t = int(input().rstrip())

for _ in range(t):
    a, b = map(int, input().split())
    print(get_lcm(a, b))
