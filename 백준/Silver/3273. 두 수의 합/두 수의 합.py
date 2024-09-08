from sys import stdin

input = stdin.readline

n = int(input().rstrip())  # n: 수열의 크기
lst = list(map(int, input().split()))  # lst: 수열(서로 다른 수)
x = int(input().rstrip())  # x: 자연수

dic = {}
for num in lst:
    dic[num] = x - num  # (x - num) + num = x

cnt = 0
for num in lst:
    if (x - num) in dic:
        cnt += 1

print(cnt // 2)
