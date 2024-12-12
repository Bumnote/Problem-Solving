from sys import stdin
from collections import deque

input = stdin.readline


def change_number(m, n):
    if m == 0:
        return 0

    dq = deque()
    while m > 0:
        dq.appendleft(m % n)
        m //= n

    ans = ""
    dic = {10: "A", 11: "B", 12: "C", 13: "D", 14: "E", 15: "F"}
    for elem in dq:
        if 10 <= elem <= 15:
            ans += dic[elem]
        else:
            ans += str(elem)

    return ans


# 10진수 m -> n진수
m, n = map(int, input().split())
print(change_number(m, n))
