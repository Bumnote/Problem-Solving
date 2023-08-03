def solution(price, money, count):
    
    need_total = price * count * (count + 1) // 2
    answer =  need_total - money if need_total > money else 0

    return answer