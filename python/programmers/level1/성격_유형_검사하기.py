def gen():
    n = 0
    while True:
        n += 1
        yield n


g = gen()
for _ in range(0, 100):
    print(next(g))
