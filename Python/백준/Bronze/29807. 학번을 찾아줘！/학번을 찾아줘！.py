from sys import stdin

input = stdin.readline

t = int(input().rstrip())
# 국어, 수학, 영어, 탐구, 제 2 외국어
t_lst = list(map(int, input().split()))
remain = 5 - len(t_lst)
t_lst = t_lst + [0] * remain
kor, mat, eng, sci, otr = t_lst

res_1, res_2, res_3 = 0, 0, 0
if kor > eng:
    res_1 = (kor - eng) * 508
else:
    res_1 = (eng - kor) * 108

if mat > sci:
    res_2 = (mat - sci) * 212
else:
    res_2 = (sci - mat) * 305

if otr > 0:
    res_3 = otr * 707

res = (res_1 + res_2 + res_3) * 4763
print(res)
