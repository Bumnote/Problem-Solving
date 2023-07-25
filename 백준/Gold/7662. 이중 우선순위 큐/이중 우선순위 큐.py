from sys import stdin
from collections import deque
from heapq import heappush, heappop

input = stdin.readline

tc = int(input().strip())  # tc: 테스트 케이스

for _ in range(tc):
    min_pq = []  # 최소 힙
    max_pq = []  # 최대 힙
    h_map = dict()
    length = 0
    k = int(input().strip())  # k: 입력값의 개수
    for _ in range(k):
        command, num = input().split()
        num = int(num)
        # 삽입하는 경우
        if command == "I":
            heappush(min_pq, num)
            heappush(max_pq, -num)
            length += 1
            # dictionary에 해당 수의 개수를 저장해둔다.
            if num not in h_map:
                h_map[num] = 1
            else:
                h_map[num] += 1

        # 삭제하는 경우
        else:
            # 애초부터 길이가 0 이면, 무시한다.
            if length == 0:
                continue
            # 최댓값을 삭제하는 경우
            elif num == 1:
                while True:
                    temp = -heappop(max_pq)
                    # pop하려는 숫자가 존재한다면 -> pop
                    if h_map[temp] >= 1:
                        h_map[temp] -= 1
                        break

            else:
                while True:
                    temp = heappop(min_pq)
                    # pop하려는 숫자가 존재한다면 -> pop
                    if h_map[temp] >= 1:
                        h_map[temp] -= 1
                        break

            length -= 1
            # length 가 0이 되면, heap 초기화
            if length == 0:
                min_pq.clear()
                max_pq.clear()

    if length == 0:
        print("EMPTY")
    else:
        while h_map[-max_pq[0]] == 0:
            heappop(max_pq)
        while h_map[min_pq[0]] == 0:
            heappop(min_pq)

        print(f"{-max_pq[0]} {min_pq[0]}")
