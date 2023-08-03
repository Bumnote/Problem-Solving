def binary_search(target, num_list):
    left = 0 
    right = len(num_list) - 1
    
    while left <= right:
        mid = (left + right) // 2
        if num_list[mid] == target:
            return 1
        elif num_list[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    return 0 


def solution(num_list, n):
    num_list.sort()
    answer = binary_search(n, num_list)
    return answer