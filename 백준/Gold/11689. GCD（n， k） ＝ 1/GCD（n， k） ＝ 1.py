from sys import stdin
from math import isqrt

input = stdin.readline

n = int(input().strip())  # n 이하의 n과 서로소인 자연수를 구하자.
ans = n

for i in range(2, isqrt(n) + 1):
    if n % i == 0:
        ans -= ans // i  # i를 약수로 가지는 수들 제거
        while n % i == 0:
            n //= i  # 숫자 n의 소인수에서 i를 모두 제거

# 제곱근보다 큰 소인수가 존재하는 경우 -> 제거
# 제곱근보다 큰 소인수가 있다면, 반드시 하나만 존재한다.
if n > 1:
    ans -= ans // n

print(ans)
