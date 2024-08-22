from sys import stdin

input = stdin.readline

n = int(input().rstrip())

dic = {"Never gonna give you up",
       "Never gonna let you down",
       "Never gonna run around and desert you",
       "Never gonna make you cry",
       "Never gonna say goodbye",
       "Never gonna tell a lie and hurt you",
       "Never gonna stop"}

flag = False
for _ in range(n):
    st = input().rstrip()
    if st not in dic:
        flag = True

print("Yes" if flag else "No")
