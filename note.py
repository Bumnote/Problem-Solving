from sys import stdin, setrecursionlimit

setrecursionlimit(10 ** 5)
input = stdin.readline


def GCD(a, b, cnt):
    if a == b:
        return cnt

    if a < b:
        a, b = b, a

    return GCD(b, a - b, cnt + 1)


a, b = map(int, input().split())

ans = GCD(a, b, 0)
print(ans)
