from sys import stdin

input = stdin.readline

n, k = map(int, input().split())
lst = list(map(int, input().split()))
lst.sort(reverse=True)  # 내림차순 정렬

print(lst[k - 1])
