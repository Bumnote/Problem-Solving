from sys import stdin

input = stdin.readline

s = input().strip()

if s == "NLCS":
    print("North London Collegiate School")
elif s == "BHA":
    print("Branksome Hall Asia")
elif s == "KIS":
    print("Korea International School")
else:
    print("St. Johnsbury Academy")
