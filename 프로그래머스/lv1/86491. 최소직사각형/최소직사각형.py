def solution(sizes):
    
    s_w, s_h = 0, 0 
    for s in sizes:
        if s_w < max(s):
            s_w = max(s)
        
        if s_h < min(s):
            s_h = min(s)
        
    answer = s_w * s_h
    return answer