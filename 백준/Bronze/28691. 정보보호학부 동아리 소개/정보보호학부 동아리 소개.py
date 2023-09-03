from sys import stdin

input = stdin.readline

s = input().strip()

if s == "M":
    print("MatKor")
elif s == "W":
    print("WiCys")
elif s == "C":
    print("CyKor")
elif s == "A":
    print("AlKor")
else:
    print("$clear")
