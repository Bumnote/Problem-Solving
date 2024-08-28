from sys import stdin

input = stdin.readline

word = input().rstrip()
dic = {}
for ch in word:
    # 소문자는 대문자로 변경해서 취급한다.
    if 97 <= ord(ch) <= 122:
        ch = chr(ord(ch) - 32)
    if ch not in dic:
        dic[ch] = 1
    else:
        dic[ch] += 1

# 해당 단어의 개수를 기준으로 내림차순 정렬
lst = sorted(dic.items(), key=lambda x: -x[1])

if len(lst) == 1:
    print(lst[0][0])
else:
    # 빈도수가 같은 알파벳이 존재한다면 -> "?" 출력
    if lst[0][1] == lst[1][1]:
        print("?")
    else:
        print(lst[0][0])
