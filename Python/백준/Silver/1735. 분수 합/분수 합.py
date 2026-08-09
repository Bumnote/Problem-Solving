from sys import stdin

input = stdin.readline


def get_gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a


a_c, a_m = map(int, input().split())
b_c, b_m = map(int, input().split())

r_c, r_m = a_c * b_m + a_m * b_c, a_m * b_m
GCD = get_gcd(r_c, r_m)

print(f"{r_c // GCD} {r_m // GCD}")
