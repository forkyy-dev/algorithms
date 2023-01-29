r = [1, 2, 3]

for i, v in enumerate(r):
    print(i, v)

range_ = [n * 2 for n in r if n % 2 == 1]

print(range_)

dic = {'1': 1, '2': 2}
print(dic.get('3') is None)
