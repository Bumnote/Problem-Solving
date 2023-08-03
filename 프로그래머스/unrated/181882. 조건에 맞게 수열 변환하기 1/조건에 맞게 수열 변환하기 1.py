def solution(arr):
    answer = [0]* len(arr)
    for i in range(len(arr)):
        if arr[i] >= 50 and arr[i] % 2 == 0:
            answer[i] = arr[i] // 2 
        elif arr[i] < 50 and arr[i] % 2 == 1:
            answer[i] = arr[i] * 2
        else:
            answer[i] = arr[i]
            
    return answer