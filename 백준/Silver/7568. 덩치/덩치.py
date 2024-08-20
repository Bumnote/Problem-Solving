from sys import stdin

input = stdin.readline

n = int(input().rstrip())

persons = []
for _ in range(n):
    weight, tall = map(int, input().split())
    persons.append((weight, tall))

order = []
for i in range(n):
    cnt = 0
    for j in range(n):
        # 자기 자신은 제외
        if i == j:
            continue
        # 나보다 덩치가 큰 사람들의 명 수를 구한다.
        if persons[i][0] < persons[j][0] and persons[i][1] < persons[j][1]:
            cnt += 1

    order.append(cnt + 1)

print(*order)
