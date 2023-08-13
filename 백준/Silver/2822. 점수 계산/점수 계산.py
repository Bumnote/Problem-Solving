l = []
a = []
maxi = 0
for i in range(8):
    l.append(int(input()))

for i in range(5):
    a.append(l.index(max(l))+1)
    maxi += l[l.index(max(l))]
    l[l.index(max(l))] = 0
a.sort()
print(maxi)

for i in a:
    print(i, end=" ")