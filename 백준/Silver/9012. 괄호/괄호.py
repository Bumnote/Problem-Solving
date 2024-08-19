from sys import stdin

input = stdin.readline

tc = int(input().rstrip())

for _ in range(tc):
    text = input().rstrip()
    stk = []

    flag = True
    for ch in text:
        # stk가 비어있는데, 닫힌 괄호가 들어온다면 -> False
        if not stk and ch == ")":
            flag = False
            break
        # 열린 괄호라면 -> append() 한다.
        if ch == "(":
            stk.append("(")
        # 닫힌 괄호라면 -> stk의 마지막 괄호가 열린 괄호인지 확인한다.
        else:
            if stk[-1] == "(":
                stk.pop()
            else:
                flag = False
                break

    # 열린 괄호만 있을 경우 -> stk에 원소가 남아있으므로 False 처리
    if stk:
        flag = False

    if flag:
        print("YES")
    else:
        print("NO")
