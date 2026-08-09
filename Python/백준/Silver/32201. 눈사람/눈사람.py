from sys import stdin, maxsize

input = stdin.readline

n = int(input().rstrip())
a_lst = list(map(int, input().split()))
b_lst = list(map(int, input().split()))

a_dic = {a_lst[i]: i for i in range(n)}
b_dic = {b_lst[i]: i for i in range(n)}

ans = []
MAX = -maxsize
for i in range(n):
    diff = a_dic[b_lst[i]] - b_dic[b_lst[i]]

    if MAX < diff:
        MAX = diff
        ans = [b_lst[i]]
    elif MAX == diff:
        ans.append(b_lst[i])

print(*ans)
