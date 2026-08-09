from sys import stdin

input = stdin.readline


def get_next_number(num):
    st = list(map(int, str(num)))

    next_number = 1
    for elem in st:
        next_number *= elem
    return next_number


while True:
    num = int(input().rstrip())
    if num == 0:
        break

    while True:
        print(num, end=" ")
        if num // 10 == 0:
            break
        num = get_next_number(num)
