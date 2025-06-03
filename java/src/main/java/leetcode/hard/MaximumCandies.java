package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumCandies {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        if(initialBoxes.length == 0) {
            return 0;
        }

        int n = status.length;
        boolean[] hasKey = new boolean[n];
        boolean[] hasBox = new boolean[n];
        boolean[] opened = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        // 초기 박스 설정
        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (status[box] == 1) {
                queue.offer(box);
            }
        }

        int totalCandies = 0;

        while (!queue.isEmpty()) {
            int box = queue.poll();
            if (opened[box]) continue;
            opened[box] = true;

            totalCandies += candies[box];

            // 열쇠 수집
            for (int key : keys[box]) {
                if (!hasKey[key]) {
                    hasKey[key] = true;
                    if (hasBox[key] && !opened[key]) {
                        queue.offer(key);
                    }
                }
            }

            // 박스 수집
            for (int contained : containedBoxes[box]) {
                if (!hasBox[contained]) {
                    hasBox[contained] = true;
                }
                if ((status[contained] == 1 || hasKey[contained])
                        && !opened[contained]) {
                    queue.offer(contained);
                }
            }
        }

        return totalCandies;
    }
}

/*
//link: https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/description/

### 1. 최초 접근 방식
주어진 배열들을 flatten해서 결과를 비교하는 방식으로 접근했음.
```md
0. open_available_set(oas)과 box_set(bs) 자료구조를 각각 생성한다.
1. status 배열의 1인 index를 oas에 넣는다.
2. keys배열을 순회하면서 내부 배열에 있는 모든 숫자들을 꺼내서 oas에 넣는다.
3. contained_boxes를 순회하면서 각 값을 bs에 넣는다.
4. bs를 순회하면서 oas에 해당 index가 존재하는지 확인 후 존재할 경우 해당 박스의 candies를 모아 합산한다.
```
#### 해당 방식의 허점
keys의 열쇠는 실제 상자를 열게 되었을때 사용할 수 있다!
- 만약 3번 상자안에 3번 상자를 열 수 있는 key가 존재한다고하면 결과적으로 3번 상자는 열수가 없다.
하지만 flatten을 하는 순간 열 수 있는 상자로 판단하게 된다.

### 2. 해결
BFS로 접근해서 상자를 순서대로 열고, 해당 시점에 발견한 key와 박스를 큐에 담아서 해당 작업을 반복하도록 구현.
해결까지 걸린 시간: 1시간
 */
