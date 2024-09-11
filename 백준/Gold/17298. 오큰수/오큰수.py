from sys import stdin

input = stdin.readline

n = int(input().rstrip())
ans = [-1 for _ in range(n)]  # 정답 리스트

lst = list(map(int, input().split()))
stk = []

# 인덱스로 접근
for i in range(n):
    # 스택에 원소가 있고, 스택의 마지막 값을 인덱스로 하는 리스트의 값이 현재의 값보다 작을 동안 반복 
    while stk and lst[stk[-1]] < lst[i]:
        ans[stk.pop()] = lst[i] # 저장된 인덱스들에 대해서 모두 현재의 값을 저장한다. 

    stk.append(i)

print(*ans)
