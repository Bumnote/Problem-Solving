from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

n = int(input().rstrip())

lecture = []
for _ in range(n):
    s, t = map(int, input().split())  # s: 시작, t: 끝
    lecture.append((s, t))

# 시작 시간 순서, 같다면 종료 시간 순서 오름차순 정렬
lecture = sorted(lecture, key=lambda x: (x[0], x[1]))
pq = [lecture[0][1]]  # 첫 수업 종료 시간 저장

for i in range(1, n):
    # 앞 수업의 종료 시간보다 다음 수업의 시작 시간이 작은 경우
    if pq[0] > lecture[i][0]:
        heappush(pq, lecture[i][1])
    # 앞 수업의 종료 시간보다 다음 수업의 시작 시간이 같거나 큰 경우
    else:
        heappop(pq)  # 이전 수업을 제거한다.
        heappush(pq, lecture[i][1])  # 현재 수업의 종료 시간을 저장한다.

print(len(pq))
