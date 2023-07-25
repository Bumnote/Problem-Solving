from sys import stdin

input = stdin.readline

n = int(input().strip())  # n: 사람의 수
n_list = list(map(int, input().split()))  # 각 사람이 돈을 인출하는데 걸리는 시간
n_list.sort()  # O(nlogn)

ans = n_list[0]
for i in range(1, n):
    n_list[i] = n_list[i - 1] + n_list[i]  # 누적합 활용
    ans += n_list[i]

print(ans)
