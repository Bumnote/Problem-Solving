from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n = int(input().strip())  # n번째 피보나치 수 (0 <= n <= 10,000)

## 문제 해결 부분 ##
n_list = [0, 1] 
# 반복문으로 순차적으로 피보나치 수를 구하자.
for i in range(n - 1):
    next = n_list[i] + n_list[i + 1]
    n_list.append(next)

print(n_list[n])
