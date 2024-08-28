from sys import stdin

input = stdin.readline

words = [["_" for _ in range(15)] for _ in range(5)]

for i in range(5):
    s = input().rstrip()
    for j in range(len(s)):
        words[i][j] = s[j]  # 단어를 저장

for j in range(15):
    for i in range(5):
        print(words[i][j] if words[i][j] != "_" else "", end="")
