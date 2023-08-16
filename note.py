from sys import stdin

input = stdin.readline

n = int(input().strip())  # n: 명령의 수
stk = []

for _ in range(n):
    command = input().split()
    if len(command) == 2:
        c, num = command
        stk.append(num)

    elif command[0] == "2":
        if stk:
            print(stk.pop())
        else:
            print(-1)

    elif command[0] == "3":
        print(len(stk))

    elif command[0] == "4":
        if stk:
            print(0)
        else:
            print(1)

    elif command[0] == "5":
        if stk:
            print(stk[-1])
        else:
            print(-1)
