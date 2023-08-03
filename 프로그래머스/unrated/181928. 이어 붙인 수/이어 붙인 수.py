def solution(num_list):
    odd_s, even_s = "", ""
    for s in num_list:
        if s % 2 == 1:
            odd_s += str(s) 
        else:
            even_s += str(s) 
    
    answer = int(odd_s) + int(even_s)
    return answer