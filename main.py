def solution(s):
    zero_cnt = 0  # 없앤 0의 개수
    cnt = 0  # 변환 횟수

    # "1"이 될 때까지 반복
    while s != "1":
        cnt += 1  # 변환 횟수 증가
        zero_cnt += s.count("0")  # 0의 개수 더하기
        temp = "".join([elem for elem in s if elem == "1"])  # 문자열 s에서 0을 모두 빼낸 결과
        s = bin(len(temp))[2:]  # 2진수로 변환

    return [cnt, zero_cnt]
