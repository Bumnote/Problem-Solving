from sys import stdin

input = stdin.readline

s = input().rstrip()

postfix = ""
stk = []
for ch in s:
    if ch == "(":
        stk.append(ch)
    elif ch == ")":
        while stk and stk[-1] != "(":
            postfix += stk.pop()
        stk.pop()
    elif ch == "*" or ch == "/":
        while stk and (stk[-1] == "*" or stk[-1] == "/"):
            postfix += stk.pop()
        stk.append(ch)
    elif ch == "+" or ch == "-":
        while stk and stk[-1] != "(":
            postfix += stk.pop()
        stk.append(ch)
    else:
        postfix += ch

while stk:
    postfix += stk.pop()

print(postfix)
