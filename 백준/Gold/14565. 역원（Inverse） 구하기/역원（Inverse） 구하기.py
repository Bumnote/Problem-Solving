from sys import stdin

input = stdin.readline

# a, b, c - 정수
# (a + b) % n = 0 -> b는 a의 덧셈역
# (a * b) % n = 1 -> b는 a의 곱셈역 / 없으면 -1
N, A = map(int, input().split())

p = N - A  # 덧셈역
m = 0  # 곱셈역


# 유클리드 알고리즘 -> 두 수의 최대 공약수를 구한다.
def get_gcd(a, b):
    if a < b:
        a, b = b, a
    if b == 0:
        return a
    return get_gcd(b, a % b)


# 확장 유클리드 알고리즘 -> Ax + By = C 방정식의 (x, y) 정수해를 구한다.
def extended_euclid(a, b):
    if a < b:
        a, b = b, a
    res = [0] * 2
    if b == 0:
        res[0] = 1
        res[1] = 0
        return res

    quot = a // b
    v = extended_euclid(b, a % b)
    res[0] = v[1]
    res[1] = v[0] - v[1] * quot
    return res


gcd = get_gcd(N, A)
if gcd != 1:
    m = -1
else:
    res = extended_euclid(N, A)
    m = res[1]
    while m < 0:
        m += N

print(f"{p} {m}")
