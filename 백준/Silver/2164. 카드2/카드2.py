from sys import stdin
from collections import deque

input = stdin.readline

n = int(input().rstrip())
cards = deque([i for i in range(n, 0, - 1)])

# 1장이 될 때까지 반복
while len(cards) != 1:
    cards.pop()  # 제일 위에 있는 카드를 버린다.
    cards.appendleft(cards.pop())  # 그 다음, 제일 위에 있는 카드를 가장 아래에 넣는다.

print(cards.pop())
