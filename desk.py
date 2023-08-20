from sys import stdin
from collections import deque

input = stdin.readline

n = int(input().strip())  # n: 명령의 수

dq = deque()
for _ in range(n):
    command = list(input().split())
    if len(command) == 2:
        # 정수 X를 덱의 앞에 삽입
        if command[0] == "1":
            dq.appendleft(command[1])
        # 정수 X를 덱의 뒤에 삽입
        else:
            dq.append(command[1])

    else:
        num = int(command.pop())
        if num == 3:
            if dq:
                print(dq.popleft())
            else:
                print(-1)
        elif num == 4:
            if dq:
                print(dq.pop())
            else:
                print(-1)
        elif num == 5:
            print(len(dq))
        elif num == 6:
            if dq:
                print(0)
            else:
                print(1)
        elif num == 7:
            if dq:
                print(dq[0])
            else:
                print(-1)
        else:
            if dq:
                print(dq[-1])
            else:
                print(-1)
