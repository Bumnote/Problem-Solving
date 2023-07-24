from sys import stdin

input = stdin.readline

n = int(input().strip())  # n: 수열 A의 크기
A = list(map(int, input().split()))  # 수열 A
stk = []

ans = [-1] * n
for i in range(n):

    # 스택이 비어있지 않고, 현재 인덱스의 값이 이전 인덱스의 값들보다 크다면 -> 오큰수 저장
    while stk and A[stk[-1]] < A[i]:
        ans[stk.pop()] = A[i]

    stk.append(i)  # 현재 인덱스 append

print(*ans)
