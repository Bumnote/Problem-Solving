from sys import stdin

input = stdin.readline

n = int(input().strip())  # n: A의 원소의 개수 (1 <= n <= 100_000)
A = list(map(int, input().split()))

m = int(input().strip())  # m: B의 원소의 개수 (1 <= m <= 100_000)
B = list(map(int, input().split()))


# A에서 B의 원소가 있는 지 찾자. O(N^2) 미만의 시간 복잡도 필요 -> 이진 탐색
def binary_search(target):
    left = 0
    right = len(A) - 1

    while left <= right:
        mid = (left + right) // 2
        if target == A[mid]:
            return 1
        elif target < A[mid]:
            right = mid - 1
        else:
            left = mid + 1

    return 0


A.sort()  # O(n log n)
for elem in B:
    print(binary_search(elem))  # O(log n)
