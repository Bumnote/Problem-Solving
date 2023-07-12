from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())

## 문제 풀이 부분 ##
print("SK" if n % 2 == 1 else "CY")
