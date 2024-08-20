from sys import stdin

input = stdin.readline


def get_hash(st, L):
    r, MOD = 31, 1234567891
    SUM = 0

    for i in range(L):
        SUM += (ord(st[i]) - 96) * (r ** i)

    return SUM % MOD


L = int(input().rstrip())  # L: 문자열의 길이
st = input().rstrip()  # st: 문자열

print(get_hash(st, L))
