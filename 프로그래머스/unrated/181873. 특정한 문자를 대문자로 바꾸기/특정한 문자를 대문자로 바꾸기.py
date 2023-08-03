def solution(my_string, alp):
    answer = ''
    for s in my_string:
        if s == alp:
            s = s.upper()
        answer += s 
        
    return answer