def solution(my_string):
    answer = 0
    for elem in my_string:
        if ord('0') <= ord(elem) <= ord('9'):
            answer += int(elem)
            
    return answer