def solution(k, m, score):
    
    score = sorted(score, reverse=True)
    
    ans = 0
    for i in range(m - 1, len(score), m):
        ans += score[i] * m 
    
    return ans 