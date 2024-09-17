from sys import stdin

input = stdin.readline

t = int(input().rstrip())

for _ in range(t):
    lst = [25, 10, 5, 1]  # 25 ,10 , 5, 1
    c = int(input().rstrip())

    idx = 0
    while idx < 4:
        print(c // lst[idx], end=" ")
        c %= lst[idx]

        idx += 1

    print()
