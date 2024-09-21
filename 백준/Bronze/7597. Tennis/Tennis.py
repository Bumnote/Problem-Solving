from sys import stdin

input = stdin.readline

while True:
    s = input().rstrip()
    win_A, win_B = 0, 0
    if s == "#":
        break

    dic = {'A': 0, 'B': 0}
    deuce = False
    for i in range(len(s)):
        if s[i] == 'A':
            dic['A'] += 1
        else:
            dic['B'] += 1

        # 듀스인 상황에서는 두 점수 차가 2점이 나면 승부가 판결이 난다.
        if deuce and abs(dic['A'] - dic['B']) == 2:
            if dic['A'] > dic['B']:
                win_A += 1
            else:
                win_B += 1
            dic = {'A': 0, 'B': 0}
            deuce = False

        if not deuce and (dic['A'] == 4 or dic['B'] == 4):
            if dic['A'] == 4:
                win_A += 1
            else:
                win_B += 1
            dic = {'A': 0, 'B': 0}
            deuce = False

        if dic['A'] == 3 and dic['A'] == dic['B']:
            deuce = True

    print(f"A {win_A} B {win_B}")
