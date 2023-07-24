from sys import stdin
from collections import deque
from heapq import heappush, heappop

input = stdin.readline

n, m = map(int, input().split())  # n: 손님의 수, m: 초밥의 수
A = [deque() for _ in range(200_001)]  # 메모리를 충분하게 제공해주었다.
cnt = [0] * (n + 1) # 먹은 초밥의 개수를 담을 리스트
for i in range(1, n + 1):
    k, *temp = list(map(int, input().split()))
    for elem in temp:
        A[elem].append(i)

B = deque(map(int, input().split()))  # B: 요리되는 초밥의 종류 (순서대로)

while B:
    food = B.popleft()
    if A[food]:
        quest = A[food].popleft()
        cnt[quest] += 1

print(*cnt[1:])
