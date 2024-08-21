from sys import stdin

input = stdin.readline

n = int(input().rstrip())

MAX = 0
lst = []
for _ in range(n):
    s, e = map(int, input().split())
    lst.append((s, e))
    MAX = max(MAX, e)  # 최대 시간 저장

cnt = 0
cur_s, cur_e = 0, 0
# Greedy - 시작 시간을 기준으로 내림차순 정렬, 회의 시간을 기준으로 오름차순 정렬
for nxt_s, nxt_e in sorted(lst, key=lambda x: (x[1], x[0])):
    # 현재 끝나는 시간이 다음 시작 시간보다 작거나 같아야 한다.
    if cur_e <= nxt_s:
        cur_s, cur_e = nxt_s, nxt_e  # 정보 갱신
        cnt += 1  # 회의 횟수 증가

print(cnt)
