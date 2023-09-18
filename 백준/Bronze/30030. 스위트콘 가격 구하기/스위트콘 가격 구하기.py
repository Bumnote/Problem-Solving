from sys import stdin

input = stdin.readline

b = int(input().strip())  # b: 부가가치세를 포함한 가격

ans = b * 10 // 11
print(ans)
