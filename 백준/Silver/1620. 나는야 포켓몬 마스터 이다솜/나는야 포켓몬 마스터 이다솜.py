from sys import stdin

input = stdin.readline

n, m = map(int, input().split())

dic_name = {}  # 이름을 key로 하는 딕셔너리 
dic_idx = {}  # 번호를 key로 하는 딕셔너리
for i in range(1, n + 1):
    name = input().rstrip()
    dic_name[name] = i
    dic_idx[i] = name

for _ in range(m):
    c = input().rstrip()
    if c.isdigit():
        print(dic_idx[int(c)])
    else:
        print(dic_name[c])
