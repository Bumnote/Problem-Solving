from sys import stdin

input = stdin.readline

n, m = map(int, input().split())

n_list = [input().rstrip() for _ in range(n)]
m_list = [input().rstrip() for _ in range(m)]

s = set()
for name in n_list:
    s.add(name)

answer = []
for name in m_list:
    if name in s:
        answer.append(name)

print(len(answer))
for name in sorted(answer):
    print(name)
