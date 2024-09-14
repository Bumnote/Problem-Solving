def solution(s):
    
    st = list(s.split(" "))
    ans = []
    
    for s in st:
        word = ""
        for i in range(len(s)):
            if i == 0:
                # 첫 글자가 숫자인 경우 -> 그냥 더한다.
                if '0' <= s[i] <= '9':
                    word += s[i]
                # 첫 글자가 문자인 경우 -> 대문자를 더한다.
                else:
                    word += s[i].upper() 
            else:
                word += s[i].lower()
            
        ans.append(word)
    
    return " ".join(ans)    
