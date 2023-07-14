from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
A, B = map(int, input().split())
answer = [0]
temp = 1
flag = True
while flag:
    for i in range(temp):
        answer.append(temp)
        if len(answer) > 1001:
            flag = False
            break
    temp += 1

print(sum(answer[A:B + 1]))
