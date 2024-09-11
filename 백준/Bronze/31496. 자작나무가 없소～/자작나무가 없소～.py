from sys import stdin

input = stdin.readline

n, s = input().split()

ans = 0
for _ in range(int(n)):
    name, cnt = input().split()
    # 여러 단어로 이루어진 경우
    if "_" in name:
        name = name.split("_")
        if s in name:
            ans += int(cnt)
    # 하나의 단어로 이루어진 경우
    else:
        if name == s:
            ans += int(cnt)

print(ans)
