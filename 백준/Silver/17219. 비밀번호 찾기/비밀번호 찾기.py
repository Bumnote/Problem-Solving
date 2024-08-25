from sys import stdin

input = stdin.readline

n, m = map(int, input().split())

dic = {}
for _ in range(n):
    site, pw = input().split()
    dic[site] = pw

for _ in range(m):
    site = input().rstrip()
    print(dic[site])
