from sys import stdin

input = stdin.readline

lst = [2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9]

total = 0
st = input().rstrip()

for ch in st:
    total += (lst[ord(ch) - 65] + 1)

print(total)
