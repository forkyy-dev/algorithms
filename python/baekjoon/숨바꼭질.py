import sys
from collections import deque

input = sys.stdin.readline

dist = [0] * 100001
n, m = map(int, input().split())

q= deque()
q.append(n)

while q:
    cur = q.popleft()
    if cur == m:
        print(dist[cur])
        break
    for next_val in (cur - 1, cur + 1, cur * 2):
        if 0 <= next_val < 100001 and not dist[next_val]:
            dist[next_val] = dist[cur] + 1
            q.append(next_val)

# 풀이
# 모든 경우의 수 중 가장 짧은 거리를 반환해야함
# 한번 이동 시 3개의 경우의 수가 발생.
# BFS로 큐에 넣고 꺼내면서 범위를 벗어나지 않고, 방문하지 않았을 경우 dist의 해당 인덱스 값에 depth 늘리기
# 큐에서 꺼낸 값이 목표 지점일 경우 종료

