from sys import stdin

input = stdin.readline

n = int(input().rstrip())
a_dic = {}
b_dic = {}

for elem in list(map(int, input().split())):
    if elem not in a_dic:
        a_dic[elem] = 1
    else:
        a_dic[elem] += 1

cnt = 0
for elem in list(map(int, input().split())):
    if elem in a_dic:
        a_dic[elem] -= 1
        if a_dic[elem] == 0:
            del (a_dic[elem])
    else:
        cnt += 1

print(cnt)
