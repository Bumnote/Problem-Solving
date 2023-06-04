t = int(input())

# 테스트 케이스 
for tc in range(1, t + 1):
    ## 변수 입력 부분 ## 
    n = int(input()) # 원의 반지름 
    cnt = 0 # 원 안에 속하는 격자점의 개수 
    
    ## 문제 해결 부분 ## 
    for i in range(1, n):
        for j in range(1, n):
            # 1 사분면 내부에 속하면 cnt++
            if i ** 2 + j ** 2 <= n ** 2:
                cnt += 1
            continue
    # (1 사분면의 개수 * 4) + (축에 속하는 값 * 4) + 원점  
    print(f"#{tc} {(cnt + sum([1] * n)) *4 + 1}")

