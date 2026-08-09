from sys import stdin

input = stdin.readline

n_list = list(map(int, input().rstrip()))
dic = dict()

for number in n_list:
    if number not in dic:
        dic[number] = 1
    else:
        dic[number] += 1

six_and_nine = 0
if 6 in dic:
    six_and_nine += dic[6]
if 9 in dic:
    six_and_nine += dic[9]

cnt = six_and_nine // 2 if six_and_nine % 2 == 0 else 1 + (six_and_nine // 2)
for k, v in dic.items():
    if k == 6 or k == 9:
        continue
    cnt = max(cnt, v)

print(cnt)
