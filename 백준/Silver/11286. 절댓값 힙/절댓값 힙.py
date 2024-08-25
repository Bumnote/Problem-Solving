from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

n = int(input().rstrip())  # n: 연산의 개수

pq = []
for _ in range(n):
    x = int(input().rstrip())
    if x != 0:
        heappush(pq, (abs(x), x))
    else:
        # 원소가 존재하는 경우
        if pq:
            ab, num = heappop(pq)
            print(num)  # 절댓값이 가장 작은 수를 출력
        # 원소가 존재하지 않는 경우
        else:
            print(0)
