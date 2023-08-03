def solution(my_string, target):
    flag = False 
    
    for i in range(len(my_string) - len(target) + 1):
        if my_string[i:i + len(target)] == target:
            flag = True
    
    return 1 if flag else 0