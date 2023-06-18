from sys import stdin
from math import isqrt

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # n자리 수, (1 <= n <= 8)
odds = ["1", "3", "5", "7", "9"]

## 문제 해결 부분 ##
def isPrime(num):
    for i in range(2, isqrt(num) + 1):
        if num % i == 0:
            return False
    # for 반복문에 걸리지 않으면 소수
    return True

def dfs(x):
    # 길이가 n이 된 경우 -> print
    if len(x) == n:
        print(x)
        return

    for odd in odds:
        if isPrime(int(x + odd)):
            dfs(x + odd)


dfs("2")
dfs("3")
dfs("5")
dfs("7")
