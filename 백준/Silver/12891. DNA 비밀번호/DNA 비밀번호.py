from sys import stdin

input = stdin.readline

s, p = map(int, input().split())  # s: dna 문자열 길이, p: 부분 문자열 길이
dna = input().rstrip()  # dna 문자열
a, c, g, t = map(int, input().split())

cnt = 0
dic = {'A': 0, 'C': 0, 'G': 0, 'T': 0}

for i in range(p):
    dic[dna[i]] += 1

left, right = 0, p
while True:
    if a <= dic['A'] and c <= dic['C'] and g <= dic['G'] and t <= dic['T']:
        cnt += 1

    if right == s:
        break
    dic[dna[left]] -= 1  # 가장 왼쪽에 있는 값을 하나 뺀다.
    dic[dna[right]] += 1  # 한 칸 다음에 있는 값을 추가한다.
    left += 1
    right += 1

print(cnt)
