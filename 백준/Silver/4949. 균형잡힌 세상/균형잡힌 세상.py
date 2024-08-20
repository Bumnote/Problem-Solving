from sys import stdin

input = stdin.readline

while True:
    s = input().rstrip()
    # 입력 종료 조건
    if s == ".":
        break

    stk = []
    flag = True
    for ch in s:
        # 열린 괄호라면 -> stk 추가
        if ch == "(" or ch == "[":
            stk.append(ch)
        elif ch == ")" or ch == "]":
            if ch == ")":
                # stk가 차있고, 마지막 값이 "("라면 -> pop
                if stk and stk[-1] == "(":
                    stk.pop()
                else:
                    flag = False
                    break
            else:
                # stk가 차있고, 마지막 값이 "["라면 -> pop
                if stk and stk[-1] == "[":
                    stk.pop()
                else:
                    flag = False
                    break
        # 나머지 문자열에 대해선 -> continue
        else:
            continue
            # 열린 괄호만 있었을 경우를 대비 -> stk에 원소가 남아있으면 False
    if stk:
        flag = False

    print("yes" if flag else "no")
