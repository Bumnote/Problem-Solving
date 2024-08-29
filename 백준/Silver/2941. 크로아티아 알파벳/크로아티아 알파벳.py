from sys import stdin

input = stdin.readline

word = input().rstrip()  # word: 단어

dic = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]

cnt = 0
for ch in dic:
    cnt += word.count(ch)  # 크로아티아 알파벳의 개수를 더한다.
    word = word.replace(ch, "_")

for i in range(len(word)):
    if word[i] != "_":
        cnt += 1

print(cnt)
