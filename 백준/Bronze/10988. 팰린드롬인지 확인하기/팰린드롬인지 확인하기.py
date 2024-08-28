from sys import stdin

input = stdin.readline

word = input().rstrip()

print(1 if word == word[::-1] else 0)
