from sys import stdin

input = stdin.readline


# 유클리드 호제법 구현
def get_gcd(a, b):
    if a < b:
        a, b = b, a
    return a if b == 0 else get_gcd(b, a % b)


# 확장 유클리드 호제법 구현
def extended_euclid(a, b):
    res = [0] * 2
    if b == 0:
        res[0] = 1
        res[1] = 0
        return res
    quot = a // b
    v = extended_euclid(b, a % b)
    res[0] = v[1]
    res[1] = v[0] - v[1] * quot
    return res


t = int(input().strip())  # t: 테스트 케이스

for _ in range(t):
    K, C = map(int, input().split())  # K: 참가 인원, C: 봉지 당 사탕의 개수
    gcd = get_gcd(K, C)

    # 최대 공약수가 1이 아니라면 -> 불가능
    if gcd != 1:
        print("IMPOSSIBLE")
    # 최대 공약수가 1이라면 -> 정수해를 구한다.
    else:
        res = extended_euclid(K, -C)
        Xk, Xc = res
        # 모듈러 연산이기 때문에 C를 계속 더해줌으로써 양수로 만든다.
        while Xk <= 0 or Xc <= 0:
            Xk += C
            Xc += K

        # 선영이는 10 ** 9 개만큼의 봉지만 구매할 수 있다.
        if Xc > 10 ** 9:
            print("IMPOSSIBLE")
            continue

        print(Xc)
