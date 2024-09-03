from sys import stdin

input = stdin.readline


def get_gcd(a, b):
    if a < b:
        a, b = b, a

    while b:
        a, b = b, a % b

    return a


def get_lcm(a, b):
    gcd = get_gcd(a, b)
    return a * b // gcd


t = int(input().rstrip())  # t: 테스트 케이스

for _ in range(t):
    m, n, x, y = map(int, input().split())
    flag = False

    year = x
    last_year = get_lcm(m, n)
    while last_year >= year:
        if (year - x) % m == 0 and (year - y) % n == 0:
            flag = True
            break

        year += m

    print(year if flag else -1)
