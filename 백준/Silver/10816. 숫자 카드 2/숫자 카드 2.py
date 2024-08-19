from sys import stdin

input = stdin.readline

n = int(input().rstrip())
lst = list(map(int, input().split()))
dic = {}
for i in range(n):
    if lst[i] not in dic:
        dic[lst[i]] = 1
    else:
        dic[lst[i]] += 1

m = int(input().rstrip())
for num in list(map(int, input().split())):
    # 해당 숫자가 딕셔너리에 없다면 -> 0 출력
    if num not in dic:
        print(0, end=" ")
    # 해당 숫자가 딕셔너리에 있다면 -> 개수 출력
    else:
        print(dic[num], end=" ")
