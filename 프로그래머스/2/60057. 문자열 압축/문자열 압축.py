def solution(s):
    MIN = len(s)  # 가장 긴 경우 -> 압축되지 않은 경우

    for div in range(1, len(s)):
        temp = ""
        # 문제 해결 부분
        word, cnt = s[:div], 0
        for i in range(0, len(s), div):
            # 문자열이 계속 일치한다면 -> cnt 증가
            if s[i:i + div] == word:
                cnt += 1
            # 문자열이 일치하지 않는다면 -> temp에 저장
            else:
                # 1 개는 생략한다.
                if cnt == 1:
                    temp += word
                # 2 이상은 붙여서 저장한다.
                else:
                    temp += (str(cnt) + word)

                word, cnt = s[i:i + div], 1

            # 마지막 순회일 경우
            if (i + div) >= len(s):
                if cnt == 1:
                    temp += s[i:]
                else:
                    temp += (str(cnt) + s[i:])

        # 문자열이 압축됐다면 -> 압축된 길이 갱신
        if len(temp) < MIN:
            MIN = len(temp)

    return MIN