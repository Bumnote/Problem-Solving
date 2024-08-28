from sys import stdin

input = stdin.readline

n = int(input().rstrip())

cnt = 0
for _ in range(n):
    st = input().rstrip()
    s = set()
    flag = True

    for i in range(len(st)):
        s.add(st[i])  # 현재 문자를 집합에 저장
        # 마지막까지 탐색했다면
        if i == len(st) - 1:
            break

        # 현재 문자와 다음 문자가 같은 경우 -> continue
        if st[i] == st[i + 1]:
            continue
        # 현재 문자와 다음 문자가 다른 경우
        else:
            # 다음 문자가 이전에 나왔던 문자라면 -> break
            if st[i + 1] in s:
                flag = False  # 그룹 단어가 아니다.
                break
            # 다음 문자가 이전에 나왔던 문자가 아니라면 -> 다음으로 넘어간다.
            else:
                continue

    if flag:
        cnt += 1

print(cnt)
