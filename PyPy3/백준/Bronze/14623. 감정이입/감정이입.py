from sys import stdin

input = stdin.readline

b1 = int(input().rstrip(), 2)
b2 = int(input().rstrip(), 2)

print(bin(b1 * b2)[2:])
