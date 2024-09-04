from sys import stdin

input = stdin.readline

n = int(input().rstrip())
# total, 1, 2, 3
dic = {1: [0, 0, 0, 0], 2: [0, 0, 0, 0], 3: [0, 0, 0, 0]}
for _ in range(n):
    a, b, c = map(int, input().split())  # a: 1번, b: 2번, c: 3번
    dic[1][0] += a
    dic[1][a] += 1
    dic[2][0] += b
    dic[2][b] += 1
    dic[3][0] += c
    dic[3][c] += 1

res = sorted(dic.items(), key=lambda x: (-x[1][0], -x[1][3], -x[1][2]))
# 총점이 다른 경우
if res[0][1][0] > res[1][1][0]:
    print(f"{res[0][0]} {res[0][1][0]}")
# 총점이 같은 경우
else:
    # 3점의 개수가 다른 경우
    if res[0][1][3] > res[1][1][3]:
        print(f"{res[0][0]} {res[0][1][0]}")
    # 2점의 개수가 다른 경우
    elif res[0][1][2] > res[1][1][2]:
        print(f"{res[0][0]} {res[0][1][0]}")
    # 3점, 2점의 개수가 모두 같은 경우 -> 0 출력
    else:
        print(f"{0} {res[0][1][0]}")
