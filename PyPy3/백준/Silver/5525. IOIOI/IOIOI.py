from sys import stdin

input = stdin.readline

n = int(input().rstrip())
m = int(input().rstrip())  # m: s 길이
s = input().rstrip()

word = "I" + "OI" * n

cnt = 0
LEN = len(word)
for i in range(m - len(word) + 1):
    if s[i:i + LEN] == word:
        cnt += 1

print(cnt)
