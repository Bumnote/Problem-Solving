from sys import stdin

input = stdin.readline

lst = [0] * 10_001
n = int(input().rstrip())

# 계수 정렬 활용
for _ in range(n):
    num = int(input().rstrip())
    lst[num] += 1

for i in range(10_001):
    # 숫자가 하나라도 카운팅됐으면 그 수만큼 출력
    if lst[i] != 0:
        for j in range(lst[i]):
            print(i)
