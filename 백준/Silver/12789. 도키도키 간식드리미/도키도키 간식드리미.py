from sys import stdin
from collections import deque

input = stdin.readline

n = int(input().strip())  # n: 학생 수
n_list = deque(map(int, input().split()))
stk = []

order = 1
while n_list:
    # 현재 줄 서 있는 곳에서 제일 앞선 순서인 사람이 온 경우
    if n_list[0] == order:
        n_list.popleft()
        order += 1

    # 한 명씩만 설 수 있는 공간에 제일 앞선 순서인 사람이 있는 경우
    elif stk and stk[-1] == order:
        stk.pop()
        order += 1

    # 그렇지 않은 경우 -> 한 명씩만 설 수 있는 공간으로 이동 
    else:
        stk.append(n_list.popleft())

while stk:
    if stk.pop() == order:
        order += 1
    else:
        break

if stk:
    print("Sad")
else:
    print("Nice")
