from sys import stdin
from collections import deque


def D(num):
    return 2 * num if 2 * num < MAX else (2 * num) % MAX


def S(num):
    return num - 1 if num > 0 else 9999


def L(num):
    st = "0" * (4 - len(num)) + num
    return int(st[1:] + st[0])


def R(num):
    st = "0" * (4 - len(num)) + num
    return int(st[-1] + st[:3])


input = stdin.readline

t = int(input().rstrip())
MAX = 10_000
for _ in range(t):
    s, target = input().split()
    canVisit = [True for _ in range(MAX)]
    canVisit[int(s)] = False  # 방문 처리
    dq = deque([(s, "")])

    while dq:
        cur_s, c = dq.popleft()
        if cur_s == target:
            print(c)
            break

        for func in ["D", "S", "L", "R"]:
            if func == "D":
                nxt_s = D(int(cur_s))
            elif func == "S":
                nxt_s = S(int(cur_s))
            elif func == "L":
                nxt_s = L(cur_s)
            else:
                nxt_s = R(cur_s)

            if 0 <= nxt_s < MAX and canVisit[nxt_s]:
                canVisit[nxt_s] = False  # 방문 처리
                dq.append((str(nxt_s), c + func))
