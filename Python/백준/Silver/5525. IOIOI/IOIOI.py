from sys import stdin

input = stdin.readline

n = int(input().rstrip())
m = int(input().rstrip())  # m: s 길이
s = input().rstrip()

ans, cnt = 0, 0
l, r = 0, 3
while r <= m:
    # IOI 가 나타난 경우
    if s[l:r] == "IOI":
        cnt += 1
        l += 2
        r += 2
        # IOI 가 연속적으로 나타나다가 n개를 만족한 경우
        if cnt == n:
            ans += 1
            cnt -= 1
        continue

    # IOI 규칙이 깨진 경우
    l += 1
    r += 1
    cnt = 0

print(ans)
