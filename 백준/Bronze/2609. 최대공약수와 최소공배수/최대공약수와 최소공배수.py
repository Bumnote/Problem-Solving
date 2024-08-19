from sys import stdin

input = stdin.readline


def get_lcm(a, b):
    return a * b // get_gcd(a, b)


def get_gcd(a, b):
    if a < b:
        a, b = b, a

    # 유클리드 호제법 구현
    while b:
        a, b = b, a % b

    return a


a, b = map(int, input().split())
print(f"{get_gcd(a, b)}\n{get_lcm(a, b)}")
