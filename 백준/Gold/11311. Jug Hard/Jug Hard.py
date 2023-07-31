from sys import stdin

input = stdin.readline


def get_gcd(a, b):
    if a < b:
        a, b = b, a
    if b == 0:
        return a
    return get_gcd(b, a % b)


T = int(input().strip())  # T: 테스트 케이스
# Ax + By = C 의 해를 구할 수 있는 지 문제
for _ in range(T):
    A, B, C = map(int, input().split())

    gcd = get_gcd(A, B)
    # 최대 공약수가 C의 배수가 아니면 -> 해를 구할 수 없다.
    if C % gcd != 0:
        print("No")
    # 최대 공약수가 C의 배수이면 -> 해를 구할 수 있다. 
    else:
        print("Yes")
