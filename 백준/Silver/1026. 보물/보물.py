from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())
A = sorted(map(int, input().split()))
B = list(map(int, input().split()))

## 문제 해결 부분 ##
sorted_B = sorted(B, reverse=True)
print(sum([a * b for a, b in zip(A, sorted_B)]))
