from sys import stdin

input = stdin.readline

n = int(input().rstrip())
lst = list(map(int, input().split()))

dp = [0 for _ in range(n)]

for i, v in enumerate(sorted(lst)):
    dp[i] = v # 시간이 적게 걸리는 순서로 오름차순 정렬 

for i in range(1, n):
    dp[i] = dp[i - 1] + dp[i] # 현재 사람이 기다리는 시간 축적

print(sum(dp))
