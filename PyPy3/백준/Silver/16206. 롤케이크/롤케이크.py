from sys import stdin

input = stdin.readline

n, m = map(int, input().split())
cakes = sorted(list(map(int, input().split())), key=lambda x: (x % 10, x))

cnt = 0
for i in range(n):
    # 짜를 필요가 없는 케이크의 개수를 먼저 구한다.
    if cakes[i] == 10:
        cnt += 1

    elif cakes[i] % 10 == 0:
        cutting = (cakes[i] // 10) - 1
        # 해당 케이크를 전부 자를 수 있으면 -> cutting
        if cutting <= m:
            m -= cutting
            cnt += (cutting + 1)

        # 해당 케이크를 전부 자를 수 없다면 -> 부분 cutting
        # 남은 케이크는 길이가 10이 아니므로 개수 주의
        else:
            cnt += m
            m = 0

for i in range(n):
    if cakes[i] % 10 != 0:
        cutting = cakes[i] // 10
        if cutting <= m:
            m -= cutting
            cnt += cutting
            if m == 0:
                break
        else:
            cnt += m
            m = 0
            break

print(cnt)
