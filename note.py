from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

tc = int(input().strip())  # tc: 테스트 케이스

for _ in range(tc):
    min_pq = []  # 최소 힙
    max_pq = []  # 최대 힙
    k = int(input().strip())  # k: 입력값의 개수
    visited = [1] * k  # 방문 가능 판별 리스트
    for i in range(k):
        command, num = input().split()
        num = int(num)
        # 삽입하는 경우
        if command == "I":
            heappush(min_pq, (num, i))
            heappush(max_pq, (-num, i))
            visited[i] = True  # 방문 가능 처리
        # 삭제하는 경우
        else:
            # 최댓값을 삭제하는 경우
            if num == 1:
                if max_pq:
                    visited[heappop(max_pq)[1]] = 0  # 방문 불가능 처리
            # 최솟값을 삭제하는 경우
            else:
                if min_pq:
                    visited[heappop(min_pq)[1]] = 0  # 방문 불가능 처리
        while max_pq and visited[max_pq[0][1]] == 0:
            heappop(max_pq)
        while min_pq and visited[min_pq[0][1]] == 0:
            heappop(min_pq)

    if min_pq and max_pq:
        print(f"{-max_pq[0][0]} {min_pq[0][0]}")
    else:
        print("EMPTY")
