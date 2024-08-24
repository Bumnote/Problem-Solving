from sys import stdin

input = stdin.readline


def calc(a, b):
    if b == 1:
        return a % c

    ret = calc(a, b // 2)
    ret = (ret * ret) % c
    # b가 홀수인 경우
    if b % 2 == 1:
        ret = (ret * a) % c

    return ret


a, b, c = map(int, input().split())
print(calc(a, b))
