from sys import stdin

input = stdin.readline


class Stack:

    def __init__(self):
        self.lst = []

    def push(self, value):
        self.lst.append(value)

    def pop(self):
        return -1 if self.empty() else self.lst.pop()

    def size(self):
        return len(self.lst)

    def empty(self):
        return 1 if not self.lst else 0

    def top(self):
        return -1 if self.empty() else self.lst[-1]


stk = Stack()

n = int(input().rstrip())
for _ in range(n):
    command = input().split()
    if len(command) == 1:
        c = command[0]
        if c == "pop":
            print(stk.pop())
        elif c == "size":
            print(stk.size())
        elif c == "empty":
            print(stk.empty())
        else:
            print(stk.top())
    else:
        num = int(command[1])
        stk.push(num)
