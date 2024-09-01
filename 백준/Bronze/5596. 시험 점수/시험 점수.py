from sys import stdin

input = stdin.readline

a = list(map(int, input().split()))  # a: 민국이의 점수 정보
b = list(map(int, input().split()))  # b: 만세의 점수 정보

print(sum(a) if sum(a) >= sum(b) else sum(b))
