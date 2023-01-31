import sys
from collections import deque

input = sys.stdin.readline

direction = [[0, 1], [1, 0], [0, -1], [-1, 0]]
cur_direction = 0


def change_direction(c: str):
    global cur_direction
    if c == 'D':
        if cur_direction == 3:
            cur_direction = 0
        else:
            cur_direction += 1
    else:
        if cur_direction == 0:
            cur_direction = 3
        else:
            cur_direction -= 1


n = int(input())
m = int(input())

field = [[0] * n for _ in range(n)]
field[0][0] = 1
commands = dict()

# 사과는 -1로 표시
for _ in range(m):
    x, y = map(int, input().split())
    field[x - 1][y - 1] = -1

# 커맨드를 dictionary에 추가
for command in range(int(input())):
    sec, direct = input().split()
    commands[int(sec)] = direct

time = 0
cur_head_x, cur_head_y = 0, 0
q = deque()
q.append([cur_head_x, cur_head_y])

while True:
    time += 1
    cur_head_x += direction[cur_direction][0]
    cur_head_y += direction[cur_direction][1]

    if 0 > cur_head_x or cur_head_x >= n or 0 > cur_head_y or cur_head_y >= n or field[cur_head_x][cur_head_y] == 1:
        print(time)
        break

    if field[cur_head_x][cur_head_y] == -1:
        field[cur_head_x][cur_head_y] = 1
        q.append([cur_head_x, cur_head_y])
    else:
        field[cur_head_x][cur_head_y] = 1
        q.append([cur_head_x, cur_head_y])
        tail_x, tail_y = q.popleft()
        field[tail_x][tail_y] = 0

    if time in commands:
        change_direction(commands[time])


# 참고 : https://hongcoding.tistory.com/127