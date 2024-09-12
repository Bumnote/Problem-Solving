from sys import stdin

input = stdin.readline

n, m = map(int, input().split())

dic = {}

a_list = [int(input().rstrip()) for _ in range(n)]
b_list = [int(input().rstrip()) for _ in range(m)]

ans, cnt = 0, 0
for b in b_list:
    for i, a in enumerate(a_list, start=1):
        if a <= b:
            if i not in dic:
                dic[i] = 1
            else:
                dic[i] += 1

            if cnt < dic[i]:
                ans, cnt = i, dic[i]

            break

print(ans)
