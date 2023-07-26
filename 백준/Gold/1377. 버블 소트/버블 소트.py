from sys import stdin

input = stdin.readline

n = int(input().strip())  # n: 숫자의 개수
A = [(int(input().strip()), i) for i in range(n)]  # A: 정렬해야 하는 배열

ans = 0
for i, v in enumerate(sorted(A)):
    ans = max(ans, v[1] - i)

print(ans + 1)
