from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
s = int(input().strip())  # s: 서로 다른 n개의 자연수의 합
SUM = 0
i = 1

## 문제 해결 부분 ##
while True:
    SUM += i
    # 정답과 일치하는 경우 -> i 출력
    if s == SUM:
        print(i)
        break
    # 이미 더한 값을 더하게 되는 경우 -> 1 뺀 후 출력
    if s - SUM <= i:
        print(i)
        break

    i += 1
