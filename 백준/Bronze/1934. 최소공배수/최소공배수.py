from sys import stdin

input = stdin.readline


def get_gcd(A, B):
    if A < B:
        A, B = B, A

    if B == 0:
        return A
    return get_gcd(B, A % B)


T = int(input().strip())  # T: 테스트 케이스

for _ in range(T):
    A, B = map(int, input().split())
    print(A * B // get_gcd(A, B))
