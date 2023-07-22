from sys import stdin

input = stdin.readline


def get_gcd(a, b):
    if a < b:
        a, b = b, a

    if b == 0:
        return a

    return get_gcd(b, a % b)


tc = int(input().strip())  # tc: 테스트 케이스

for _ in range(tc):
    a, b = map(int, input().split())  # a, b의 최대 공약수를 구하자.
    print(get_gcd(a, b))  # 유클리드 호제법 구현
