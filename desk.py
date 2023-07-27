from sys import stdin

input = stdin.readline

n = int(input().strip())  # n: 숫자의 개수 (1 <= n <= 1_000)
n_list = list(map(int, input().split()))  # n개의 숫자

# R = N - Q x D (Q: 몫, R: 나머지)
def get_gcd(a, b):
    if a < b:
        a, b = b, a

    if b == 0:
        return a
    return get_gcd(b, a % b)

gcd = n_list[0]
for i in n_list:
    gcd = get_gcd(gcd, i)

print(gcd)