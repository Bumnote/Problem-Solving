from sys import stdin

input = stdin.readline

n = int(input().rstrip())
if n == 0:
    print("divide by zero")
else:
    lst = list(map(int, input().split()))

    avg = sum(lst) / n

    dic = {}
    for elem in lst:
        if elem not in dic:
            dic[elem] = 1
        else:
            dic[elem] += 1

    e = 0
    for k, v in dic.items():
        e += k * (v / n)

    print(f"{avg / e:.2f}" if n != 0 and e != 0 else "divide by zero")
