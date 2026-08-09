from sys import stdin

input = stdin.readline

while True:
    words = input().rstrip()
    if words == "END":
        break

    dic = {}

    flag = True
    for ch in words.replace(" ", ""):
        if ch not in dic:
            dic[ch] = 1
        else:
            flag = False
            break

    if flag:
        print(words)
