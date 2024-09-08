def solution(numbers):
    n = len(numbers)

    ans = [0 for _ in range(n)]
    stk = []

    for i in range(n):
        while stk and numbers[stk[-1]] < numbers[i]:
            ans[stk.pop()] = numbers[i]
        stk.append(i)

    while stk:
        ans[stk.pop()] = -1

    return ans
