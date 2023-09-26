from sys import stdin

input = stdin.readline

flag = True
for i in range(1, 6):
    name = input().strip()
    if "FBI" in name:
        print(i, end=" ")
        flag = False

if flag:
    print("HE GOT AWAY!")
