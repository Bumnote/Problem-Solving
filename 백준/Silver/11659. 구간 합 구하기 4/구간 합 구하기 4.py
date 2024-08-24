from sys import stdin

input = stdin.readline

n, m = map(int, input().split())  # n: 숫자의 개수, m: 횟수
lst = list(map(int, input().split()))
prefix = [0 for _ in range(n + 1)]
prefix[1] = lst[0]  # 전처리 작업
for i in range(2, n + 1):
    prefix[i] = lst[i - 1] + prefix[i - 1]

for _ in range(m):
    i, j = map(int, input().split())
    diff = prefix[j] - prefix[i - 1]
    print(diff)
