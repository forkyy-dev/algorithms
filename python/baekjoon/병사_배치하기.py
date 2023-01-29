import sys

input = sys.stdin.readline


size = int(input())
data = list(map(int, input().split(' ')))
result = [1] * size

for i in range(size):
    for j in range(i):
        if data[i] < data[j]:
            result[i] = max(result[i], result[j] + 1)

count = max(result)
print(size - count)