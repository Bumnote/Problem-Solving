from sys import stdin
from collections import deque

input = stdin.readline

n = int(input().rstrip())
shape = list(map(int, input().split()))

t = int(input().rstrip())

cnt = 0
ans = []
dic = {1: 3, 2: 4, 3: 1, 4: 2}
for _ in range(t):
    lst = list(map(int, input().split()))
    forward = shape * 2
    temp = deque()
    # 정방향 탐색
    for i in range(n + 1):
        if lst == forward[i:i + n]:
            cnt += 1
            ans.append(lst)
            break

    # 역방향 탐색
    for i in range(n):
        temp.appendleft(dic[shape[i]])

    reverse = list(temp) * 2
    for i in range(n + 1):
        if lst == reverse[i:i + n]:
            cnt += 1
            ans.append(lst)
            break

print(cnt)
for elem in ans:
    print(*elem)
