def solution(d, budget):
    d.sort() # 오름차순 정렬
    
    answer = 0 
    total = 0 
    # greedy 접근 
    for m in range(len(d)):
        total += d[m]
        if total <= budget:
            answer += 1
        
        
    return answer