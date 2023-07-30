from sys import stdin

input = stdin.readline

n, m = map(int, input().split(":"))


# 유클리드 호제법 구현
def get_gcd(a, b):
    if a < b:
        a, b = b, a

    if b == 0:
        return a

    return get_gcd(b, a % b)


gcd = get_gcd(n, m)
print(f"{n // gcd}:{m // gcd}")
