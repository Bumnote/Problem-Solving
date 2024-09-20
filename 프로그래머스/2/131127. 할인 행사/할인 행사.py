def solution(want, number, discount):
    answer = 0
    
    w_dic = {}
    for i in range(len(want)):
        w_dic[want[i]] = number[i]
        
    
    LEN = len(discount)
    for i in range(LEN - 10 + 1):
        temp = {}
        for j in range(i, i + 10):
            if discount[j] not in temp:
                temp[discount[j]] = 1
            else:
                temp[discount[j]] += 1
            
        if w_dic == temp:
            answer += 1
        
    return answer