from sys import stdin

input = stdin.readline

while True:
    word = input().strip()
    if word == "*":
        break

    flag = True  # 중복 여부 변수 
    for i in range(1, len(word)):
        s = set()
        total = 0
        for j in range(len(word) - i):
            st = word[j] + word[j + i]
            s.add(st)
            total += 1

        # 중복되는 경우가 있다면 -> 개수가 틀리다는 점을 이용
        if total != len(s):
            flag = False
            break

    if flag:
        print(f"{word} is surprising.")
    else:
        print(f"{word} is NOT surprising.")
