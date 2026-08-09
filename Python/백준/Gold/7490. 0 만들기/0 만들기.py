from sys import stdin

input = stdin.readline


def bt(cnt, n):
  # n - 1개의 연산자 조합을 만든 경우 -> 판단
  if cnt == n - 1:
    expr = '1'
    for i in range(2, n + 1):
      if lst[i - 2] != ' ':
        expr += lst[i - 2]
      expr += str(i)

    # expr 연산
    result = eval(expr)
    if result == 0:
      output = '1'
      for i in range(2, n + 1):
        output += lst[i - 2] + str(i)
      print(output)
    return

  for ch in [' ', '+', '-']:
    lst.append(ch)
    bt(cnt + 1, n)
    lst.pop()


tc = int(input().strip())

for _ in range(tc):
  n = int(input().strip())

  lst = []
  bt(0, n)
  print()
