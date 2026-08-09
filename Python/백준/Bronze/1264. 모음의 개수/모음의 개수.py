from sys import stdin

input = stdin.readline

while True:
    st = input().rstrip()
    if st == "#":
        break

    dic = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
    cnt = 0
    for ch in st:
        if ch in dic:
            cnt += 1

    print(cnt)
