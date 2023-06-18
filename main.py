from sys import stdin, maxsize
from math import isqrt

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # a: GCD, b:LCM


## 문제 해결 부분 ##
# 서로소를 판별하는 함수
def isTrue(x, y):
    for i in range(2, x):
        if x % i == 0 and y % i == 0:
            return False
    return True


temp = m // n  # LCM = i * j * GCD
a, b = 0, 0
min_sum = maxsize  # 두 정수의 합의 최솟값을 담을 변수

for i in range(1, isqrt(temp) + 1):
    # temp가 나누어 떨어지면서, 서로소인 경우 -> 정답 조건에 해당된다.
    if temp % i == 0 and isTrue(i, temp // i):
        if min_sum > i + (temp // i):
            a, b = i, temp // i
            min_sum = i + (temp // i)

print(n * a, n * b)
