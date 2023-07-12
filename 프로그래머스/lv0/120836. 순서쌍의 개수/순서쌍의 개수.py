from math import isqrt

def solution(n):
    answer = 0
    flag = False 
    
    if isqrt(n)**2 == n:
        flag = True
        
    for i in range(1,isqrt(n) + 1):
        if n % i == 0:
            answer += 1 
            
    if flag:
        answer = ((answer - 1) * 2) + 1
    else:
        answer *= 2
        
    return answer