from sys import stdin

input = stdin.readline

n = int(input().strip())

cnt = 0
for _ in range(n):
    word = input().rstrip()
    if len(word) % 2 == 0:
        stk = []
        for ch in word:
            if ch == "A":
                if not stk or stk[-1] != "A":
                    stk.append("A")
                elif stk[-1] == "A":
                    stk.pop()

            else:
                if not stk or stk[-1] != "B":
                    stk.append("B")
                elif stk[-1] == "B":
                    stk.pop()

        if not stk:
            cnt += 1

print(cnt)
