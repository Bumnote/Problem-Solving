from sys import stdin

input = stdin.readline

n, s = map(int, input().split())  # n: 동생 수, s:수빈 위치
pos_l = list(map(lambda x: abs(s - x), map(int, input().split())))


def get_gcd(a, b):
    if a < b:
        a, b = b, a

    if b == 0:
        return a

    return get_gcd(b, a % b)


ans = pos_l[0]
for num in pos_l:
    ans = get_gcd(ans, num)

print(ans)
