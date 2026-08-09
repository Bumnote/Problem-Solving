from sys import stdin

input = stdin.readline

# b: 버거 개수, c: 사이드 메뉴 개수, d: 음료의 개수
b, c, d = map(int, input().split())

MIN = min(b, c, d)
burgers = sorted(map(int, input().split()), reverse=True)
sides = sorted(map(int, input().split()), reverse=True)
beverages = sorted(map(int, input().split()), reverse=True)

before = sum(burgers) + sum(sides) + sum(beverages)
after = (sum(burgers[:MIN]) + sum(sides[:MIN]) + sum(beverages[:MIN])) * 0.9 + (
        sum(burgers[MIN:]) + sum(sides[MIN:]) + sum(beverages[MIN:]))

print(before)
print(int(after))
