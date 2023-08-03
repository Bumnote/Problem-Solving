s = input().strip()

answer = ""
for elem in s:
    if ord('a') <= ord(elem) <= ord('z'):
        answer += elem.upper()
    else:
        answer += elem.lower()

print(answer)