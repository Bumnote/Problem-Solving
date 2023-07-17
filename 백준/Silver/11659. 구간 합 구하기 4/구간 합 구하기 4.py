from sys import stdin

input = stdin.readline

n, m = map(int, input().split())  # n: 수의 개수, m: 테스트 케이스
n_list = list(map(int, input().split()))
pre = [0]  # 전처리 

for i in range(n):
    pre.append(pre[i] + n_list[i])

for _ in range(m):
    s, e = map(int, input().split())  # [s ~ e]
    print(pre[e] - pre[s - 1])
