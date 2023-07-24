from sys import stdin
from heapq import heapify, heappush, heappop

input = stdin.readline

N, H, T = map(int, input().split())  # N: 인구 수, H: 센티의 키, T: 가능한 뿅망치 횟수

heights = []  # N명의 거인 키 리스트
for _ in range(N):
    heappush(heights, -int(input().strip()))

# 센티보다 큰 거인이 아예 없는 경우 -> 뿅망치를 사용하지 않아도 된다.

if -heights[0] < H:
    print(f"YES\n{0}")

else:
    flag = False
    cnt = 0
    for t in range(1, T + 1):
        height = -heappop(heights)
        # 키가 1이라면 뿅망치의 영향을 받지 않는다.
        if height == 1:
            heappush(heights, -height)
        # 키가 1이 아닌 경우 -> (키 // 2)
        else:
            heappush(heights, -(height // 2))

        # 가장 큰 키가 센티보다 작아졌다면 -> 해당 횟수를 저장한다.
        if -heights[0] < H:
            flag = True
            cnt = t
            break

    if flag:
        print(f"YES\n{cnt}")
    else:
        print(f"NO\n{-heights[0]}")
