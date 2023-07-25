from sys import stdin

input = stdin.readline

n = int(input().strip())  # n: 주어지는 수의 개수
n_list = [int(input().strip()) for _ in range(n)]


# 버블 정렬 구현
def bubble():
    global n_list

    for i in range(1, len(n_list)):
        for j in range(len(n_list) - i):
            # 오름차순으로 정렬
            if n_list[j] > n_list[j + 1]:
                n_list[j], n_list[j + 1] = n_list[j + 1], n_list[j]


bubble()
print(*n_list, sep="\n")
