from sys import stdin

input = stdin.readline


class Set:

    def __init__(self):
        self.s = set()

    def add(self, value):
        self.s.add(value)

    def remove(self, value):
        self.s.discard(value)

    def check(self, value):
        return 1 if value in self.s else 0

    def toggle(self, value):
        if value not in self.s:
            self.s.add(value)
        else:
            self.s.remove(value)

    def all(self):
        self.s = {i for i in range(1, 21)}

    def empty(self):
        self.s.clear()


s = Set()
m = int(input().rstrip())
for _ in range(m):
    command = input().split()
    if len(command) == 2:
        c, value = command[0], int(command[1])
        if c == "add":
            s.add(value)
        elif c == "remove":
            s.remove(value)
        elif c == "check":
            print(s.check(value))
        else:
            s.toggle(value)

    else:
        if command[0] == "all":
            s.all()
        else:
            s.empty()
