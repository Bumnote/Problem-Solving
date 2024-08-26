from sys import stdin, maxsize
from heapq import heappush, heappop

input = stdin.readline

t = int(input().rstrip())

for _ in range(t):
    k = int(input().rstrip())  # k: 연산의 개수
    dic = {}
    min_pq, max_pq = [], []
    cnt = 0
    for _ in range(k):
        c, n = input().split()  # c: 커맨드, n: 숫자
        n = int(n)
        # 정수 n을 Q에 삽입하는 연산
        if c == "I":
            cnt += 1  # 데이터 개수 증가
            # 존재 하지 않는 수라면 -> 1개 추가
            if n not in dic:
                dic[n] = 1
            # 존재하는 수라면 -> 횟수 증가
            else:
                dic[n] += 1

            heappush(min_pq, n)
            heappush(max_pq, -n)

        else:
            # 데이터가 없다면 -> D 연산 무시
            if cnt == 0:
                continue
            # Q의 데이터가 존재하고, Q에서 최댓값을 삭제하는 연산
            elif n == 1:
                while True:
                    value = -heappop(max_pq)
                    # 이미 처리가 된 경우 -> 무시
                    if dic[value] == 0:
                        continue
                    else:
                        cnt -= 1  # 개수 감소
                        dic[value] -= 1
                        break

            # Q에 데이터가 존재하고, Q에서 최솟값을 삭제하는 연산
            else:
                while True:
                    value = heappop(min_pq)
                    # 이미 처리가 된 경우 -> 무시
                    if dic[value] == 0:
                        continue
                    else:
                        cnt -= 1  # 개수 감소
                        dic[value] -= 1
                        break

    # Q가 비어있는 경우
    if cnt == 0:
        print("EMPTY")
    # Q에 원소가 1개 이상인 경우
    else:
        pq = min_pq + list(map(lambda x: -x, max_pq))
        MIN, MAX = maxsize, -maxsize
        for num in pq:
            if dic[num] >= 1:
                MIN = min(MIN, num)
                MAX = max(MAX, num)

        print(f"{MAX} {MIN}")
