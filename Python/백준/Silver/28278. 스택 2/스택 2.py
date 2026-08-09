from sys import stdin

input = stdin.readline

n = int(input().rstrip())

stk = []
for _ in range(n):
    lst = list(map(int, input().split()))
    command = lst[0]

    if command == 1:
        value = lst[1]
        stk.append(value)

    elif command == 2:
        if stk:
            print(stk.pop())
        else:
            print(-1)

    elif command == 3:
        print(len(stk))

    elif command == 4:
        print(0 if stk else 1)

    else:
        print(stk[-1] if stk else -1)
