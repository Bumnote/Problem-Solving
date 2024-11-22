from sys import stdin

input = stdin.readline

# 현재
n = int(input().rstrip())
n_lst = list(map(int, input().split()))

# 꿈
m = int(input().rstrip())
m_lst = list(map(int, input().split()))

MIN, MAX = float('inf'), -1
# 전체 길이
for i in range(len(m_lst)):
    # 간격
    for j in range(1, len(m_lst)):
        lst = []
        # 간격만큼 건너뛰기
        for k in range(0, len(m_lst), j):
            if i + k >= len(m_lst):
                break
            lst.append(m_lst[i + k])
            if n == len(lst):
                if n_lst == lst:
                    MIN = min(MIN, j - 1)
                    MAX = max(MAX, j - 1)
                break

print(f"{MIN} {MAX}" if MAX != -1 else -1)
