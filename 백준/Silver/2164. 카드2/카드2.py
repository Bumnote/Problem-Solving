from sys import stdin
from collections import deque

input = stdin.readline

n = int(input().strip())  # n: 카드의 개수
cards = deque([i for i in range(1, n + 1)])

while len(cards) > 1:
    cards.popleft()
    cards.append(cards.popleft())

print(cards[0])
