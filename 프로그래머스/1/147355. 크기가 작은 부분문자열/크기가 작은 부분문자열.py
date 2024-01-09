def solution(t, p):
    answer = 0
    L_T = len(t)
    L_P = len(p)
    
    for i in range(0, L_T - L_P + 1):
        if int(t[i:i+L_P]) <= int(p):
            answer += 1
            
    return answer