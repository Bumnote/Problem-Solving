from sys import stdin

input = stdin.readline

n, a, b = map(int, input().split())  # 2 x n 타일
a_lst = sorted(map(int, input().split()))  # 2 x 1 타일
b_lst = sorted(map(int, input().split()))  # 2 x 2 타일

MAX = 0
cnt = 0

# 타일이 홀수개인 경우 -> 2 x 1 타일 하나 넣고 시작
if n % 2 == 1:
    cnt += 1
    MAX = a_lst.pop()

while cnt < n:

    b_w, a_w = 0, 0
    if b_lst:
        b_w = b_lst[-1]

    if len(a_lst) >= 2:
        a_w = a_lst[-1] + a_lst[-2]

    if b_w >= a_w:
        MAX += b_lst.pop()
        cnt += 2
    else:
        MAX += a_lst.pop()
        MAX += a_lst.pop()
        cnt += 2

print(MAX)
