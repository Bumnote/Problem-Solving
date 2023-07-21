from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
num = int(input().strip())  # 어떤 숫자를 입력 받는다.

## 문제 해결 부분 ##
n = 1003001  # 2부터 1,000,000까지의 모든 수에 대하여 소수 판별
primes = [False, False] + [True] * (n - 1)  # 처음엔 모든 수가 소수(True)인 것으로 초기화

# 에라토스테네스의 체 알고리즘
for i in range(2, len(primes)):  # 2부터 n까지 모든 수를 파악
    if primes[i] == True:  # i가 소수인 경우 (남은 수인 경우)
        # 주어진 수 n보다 크거나 같은 소수이면서, 팰린드롬인 경우 그 수를 출력!
        # print(f"n = {n} / i = {i}")
        if num <= i and str(i) == str(i)[::-1]:
            print(i)
            break
        # i를 제외한 i의 모든 배수를 지우기
        j = 2
        while i * j <= n:
            primes[i * j] = False
            j += 1

"""
31 101
"""
