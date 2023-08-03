def solution(myString, pat):
    
    answer = 0
    l_s = myString.lower()
    p_s = pat.lower()
    
    for i in range(len(l_s) - len(p_s) + 1):
        if l_s[i:i + len(p_s)] == p_s:
            answer = 1
            break 
            
    return answer