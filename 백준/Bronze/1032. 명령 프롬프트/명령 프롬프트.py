from sys import stdin

input = stdin.readline

n = int(input().strip())  # n: 파일 이름의 개수

f_name = []
for _ in range(n):
    f_name.append(input().strip())

LEN = len(f_name[0])
ans = ""
for i in range(LEN):
    flag = True
    temp = f_name[0][i]
    for j in range(n):
        # 가장 기준이 되는 첫번째 문자와 다르다면 -> flag 변경 
        if temp != f_name[j][i]:
            flag = False
            break

    # 모든 파일 이름의 i번째 문자가 같다면 -> 해당 문자를 더해준다.
    if flag:
        ans += f_name[j][i]
    # 한번이라도 다른 문자가 존재한다면 -> "?" 문자를 더해준다.
    else:
        ans += "?"

print(ans)
