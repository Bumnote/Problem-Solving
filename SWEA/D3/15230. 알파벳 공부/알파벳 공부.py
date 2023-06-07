tc = int(input().strip())  # tc: 테스트 케이스
temp = "abcdefghijklmnopqrstuvwxyz"  # 비교 문자열

for t in range(1, tc + 1):
    ## 변수 입력 부분 ##
    s = input()

    ## 문제 풀이 부분 ##
    cnt = 0
    for i in range(len(s)):
        if temp[i] == s[i]:
            cnt += 1
        else:
            break

    print(f"#{t} {cnt}")