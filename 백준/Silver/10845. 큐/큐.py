from sys import stdin
from collections import deque

input = stdin.readline


class Queue:

    def __init__(self):
        self.q = deque()

    def push(self, value):
        self.q.append(value)

    def pop(self):
        return -1 if self.empty() else self.q.popleft()

    def size(self):
        return len(self.q)

    def empty(self):
        return 1 if not self.q else 0

    def front(self):
        return -1 if self.empty() else self.q[0]

    def back(self):
        return -1 if self.empty() else self.q[-1]


dq = Queue()
n = int(input().rstrip())

for _ in range(n):
    command = input().split()
    if len(command) == 1:
        c = command[0]
        if c == "pop":
            print(dq.pop())
        elif c == "size":
            print(dq.size())
        elif c == "empty":
            print(dq.empty())
        elif c == "front":
            print(dq.front())
        else:
            print(dq.back())
    else:
        data = command[1]
        dq.push(data)
