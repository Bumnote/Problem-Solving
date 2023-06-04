def solution(N):
    sum = 0 
    # 10으로 계속 나눈 나머지를 더해간다. 
    while (N != 0):
        sum += N % 10
        N //= 10
        
    return sum