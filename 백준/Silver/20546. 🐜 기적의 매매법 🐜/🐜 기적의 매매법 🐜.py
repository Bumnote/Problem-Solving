from sys import stdin

input = stdin.readline


def get_jun_money(money):
    cnt = 0
    for price in MachineDuck:
        if money >= price:
            cnt += money // price
            money %= price

    return money + cnt * MachineDuck[-1]


def get_sung_money(money):
    cnt = 0
    sell, buy = 0, 0
    comp = MachineDuck[0]
    for price in MachineDuck:
        if comp > price:
            sell = 0
            buy += 1
            if buy >= 3:
                cnt += money // price
                money %= price

        elif comp < price:
            buy = 0
            sell += 1
            if sell >= 3:
                money += cnt * price
                cnt = 0

        else:
            sell, buy = 0, 0

        comp = price

    return money + cnt * MachineDuck[-1]


money = int(input().rstrip())
MachineDuck = list(map(int, input().split()))  # 1일 ~ 14일
jun, sung = get_jun_money(money), get_sung_money(money)

if jun > sung:
    print("BNP")
elif jun < sung:
    print("TIMING")
else:
    print("SAMESAME")
