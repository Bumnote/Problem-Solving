from sys import stdin

input = stdin.readline

n, b = map(int, input().split())

dic = {i: chr(i + 55) for i in range(10, 36)}
# 10진법 수 n -> b 진법으로 변환
lst = []
while n:
    lst.append(n % b)
    n //= b

ans = ""
for ch in lst[::-1]:
    if 0 <= ch <= 9:
        ans += str(ch)
    else:
        ans += dic[ch]

print(ans)
