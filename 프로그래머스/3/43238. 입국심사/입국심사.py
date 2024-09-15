def solution(n, times):
    # n: 입국심사를 기다리는 사람의 수 / times: 1명 심사하는데 걸리는 시간 리스트 
    # 처음 모든 심사대는 비어있다.
    def bs(left, right, target):
        ans, person = None, None
        while left <= right:
            mid = (left + right) // 2
            person = sum([mid // time for time in times])
            # print(f"person = {person}")
            # 입국 심사한 사람이 n명 이상으로 했다면 -> right를 줄여간다.
            if person >= target:
                right = mid - 1
                ans = mid
            # 입국 심사한 사람이 n명보다 적게 했다면 -> left를 높인다.
            else:
                left = mid + 1

        return ans

    ans = bs(1, max(times) * n, n)

    return ans



