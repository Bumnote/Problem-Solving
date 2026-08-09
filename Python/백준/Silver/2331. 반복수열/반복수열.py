from sys import stdin

input = stdin.readline

a, p = map(int, input().split())
lst = [a]

while True:
    nums = list(map(int, str(lst[-1])))

    nxt = 0
    for num in nums:
        nxt += (num ** p)

    if nxt not in lst:
        lst.append(nxt)
    else:
        print(lst.index(nxt))
        break
