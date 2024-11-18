from sys import stdin

input = stdin.readline


def judge_bingo():
    bingo = 0
    # 가로 체크
    for i in range(5):
        false_cnt = 0
        for j in range(5):
            if not canVisit[i][j]:
                false_cnt += 1

        if false_cnt == 5:
            bingo += 1

    # 세로 체크
    for j in range(5):
        false_cnt = 0
        for i in range(5):
            if not canVisit[i][j]:
                false_cnt += 1

        if false_cnt == 5:
            bingo += 1

    # 대각선 체크
    false_cnt = 0
    for i in range(5):
        if not canVisit[i][i]:
            false_cnt += 1

    if false_cnt == 5:
        bingo += 1

    false_cnt = 0
    for j in range(5):
        if not canVisit[j][5 - j - 1]:
            false_cnt += 1

    if false_cnt == 5:
        bingo += 1

    return bingo


def remove_num(num):
    for i in range(5):
        for j in range(5):
            if MAP[i][j] == num:
                canVisit[i][j] = False
                return


MAP = [list(map(int, input().split())) for _ in range(5)]
canVisit = [[True for _ in range(5)] for _ in range(5)]
nums = [0]
for _ in range(5):
    nums += list(map(int, input().split()))

for cnt in range(1, 26):
    remove_num(nums[cnt])
    if judge_bingo() >= 3:
        print(cnt)
        break
