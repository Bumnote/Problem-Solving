from sys import stdin
from collections import deque

input = stdin.readline


class Deque:

    def __init__(self):
        self.dq = deque()

    def push_front(self, value):
        self.dq.appendleft(value)

    def push_back(self, value):
        self.dq.append(value)

    def pop_front(self):
        return self.dq.popleft() if self.dq else -1

    def pop_back(self):
        return self.dq.pop() if self.dq else -1

    def size(self):
        return len(self.dq)

    def empty(self):
        return 0 if self.dq else 1

    def front(self):
        return self.dq[0] if self.dq else -1

    def back(self):
        return self.dq[-1] if self.dq else -1


dq = Deque()
n = int(input().rstrip())
for _ in range(n):
    lst = list(input().split())
    if lst[0] == "push_front":
        dq.push_front(int(lst[1]))
    if lst[0] == "push_back":
        dq.push_back(int(lst[1]))
    if lst[0] == "pop_front":
        print(dq.pop_front())
    if lst[0] == "pop_back":
        print(dq.pop_back())
    if lst[0] == "size":
        print(dq.size())
    if lst[0] == "empty":
        print(dq.empty())
    if lst[0] == "front":
        print(dq.front())
    if lst[0] == "back":
        print(dq.back())
