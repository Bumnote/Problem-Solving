from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
n, m = map(int, input().split())  # n: 집합 S에 들어있는 n개의 문자열, m: 검사해야할 m개의 문자열
s_dict = {}
answer = 0

for _ in range(n):
    s_dict[input().strip()] = 0

## 문제 해결 부분 ## 
for _ in range(m):
    if input().strip() in s_dict:
        answer += 1

print(answer)
