from sys import stdin

input = stdin.readline

n = int(input().rstrip())  # n: 숫자의 개수
lst = list(map(int, input().split()))
# 좌표 압축 -> 자기 보다 작은 수의 개수
# 1. 집합화하여 오름차순 정렬 O(NlogN)
s_lst = sorted(set(lst))
dic = {v: i for i, v in enumerate(s_lst)}

# 2. 각 값에 대한 정렬된 상태의 인덱스를 활용하여 원래의 인덱스에 저장 O(N)
for i in range(n):
    lst[i] = dic[lst[i]]

print(*lst)
