from sys import stdin

input = stdin.readline

## 변수 입력 부분 ##
name = input().strip()  # 한수의 영어 이름 ( 1 <= len(s) <= 50)


## 문제 해결 부분 ##
def solve(s):
    ans = ""
    w_dict = {}
    for w in s:
        if w not in w_dict:
            w_dict[w] = 1
        else:
            w_dict[w] += 1

    # 모두 다 다른 알파벳으로 되어있으면 False
    if len(w_dict) == len(s):
        return "I\'m Sorry Hansoo"

    # 이름의 길이가 짝수라면 -> 모든 알파벳들이 짝수개 있어야 한다.
    elif len(s) % 2 == 0:
        # 알파벳의 개수가 모두 짝수라면 Palin
        for w, v in sorted(w_dict.items(), key=lambda x: x[0]):
            # 알파벳의 개수가 홀수개인 것이 있다면 not Palin
            if v % 2 != 0:
                return "I\'m Sorry Hansoo"
            ans += w * (v // 2)

        return ans + ans[::-1]

    # 이름의 길이가 홀수라면 -> 홀수개인 알파벳이 반드시 하나 있어야 한다.
    else:
        odd_cnt = 0
        odd_w = ""
        for w, v in sorted(w_dict.items(), key=lambda x: x[0]):
            if v % 2 == 1:
                odd_cnt += 1
                odd_w = w
                # 홀수개인 알파벳이 2개 이상이라면 not Palin
                if odd_cnt > 1:
                    return "I\'m Sorry Hansoo"

            ans += w * (v // 2)
        return ans + odd_w + ans[::-1]


if len(name) == 1:
    print(name)
else:
    print(solve(name))
