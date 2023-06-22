from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # n: 링의 개수
rings = list(map(int, input().split()))  # n개의 링


## 문제 해결 부분 ##
# 유클리드 호제법으로 두 수의 최대공약수 구하기
def get_gcd(a, b):
    if a < b:
        a, b = b, a

    if b == 0:
        return a

    return get_gcd(b, a % b)


for i in range(1, len(rings)):
    GCD = get_gcd(rings[0], rings[i])
    print(f"{rings[0] // GCD}/{rings[i] // GCD}")  # 기약분수로 표현
