from sys import stdin

input = stdin.readline

n = int(input().rstrip())
st = input().rstrip()
q = int(input().rstrip())
for _ in range(q):
    l, r = map(int, input().split())
    LEN = r - l + 1
    paper = st[l - 1: r]
    MAX = 0
    for i in range(1, LEN):
        score = 0
        f = list(paper[:i])
        s = list(reversed(paper[i:]))
        if len(f) <= len(s):
            for j in range(len(f)):
                if f[len(f) - j - 1] == s[len(s) - j - 1]:
                    score += 1

        else:
            for j in range(len(s)):
                if f[len(f) - j - 1] == s[len(s) - j - 1]:
                    score += 1

        MAX = max(MAX, score)

    print(MAX)
