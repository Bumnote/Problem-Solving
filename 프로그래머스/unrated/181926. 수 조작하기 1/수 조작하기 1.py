def solution(n, control):
    answer = n
    for command in control:
        if command == "w":
            answer += 1
        elif command == "s":
            answer -= 1
        elif command == "d":
            answer += 10
        else:
            answer -= 10
            
    return answer