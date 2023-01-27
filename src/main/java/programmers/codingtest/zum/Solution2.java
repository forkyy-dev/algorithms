package programmers.codingtest.zum;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 app = new Solution2();
        int[][] data = {{1,0,5},{2,2,2},{3,3,1},{4,4,1},{5,10,2}};
//        int[][] data = {{1, 2, 10}, {2, 5, 8}, {3, 6, 9}, {4, 20, 6}, {5, 25, 5}};
        app.solution(data);
    }


    public int[] solution(int[][] data) {
        int[] answer = new int[data.length];

        Map<Integer, Print> map = new HashMap<>();
        int totalTime = data[0][2];

        for (int i = 1; i < data.length; i++) {
            int[] d = data[i];
            map.put(d[1], new Print(d[0], d[1], d[2]));
            totalTime += d[2];
        }

        int currentTime = data[0][1];
        int nextStartTime = data[0][1];
        int index = 0;

        Queue<Print> queue = new PriorityQueue<>();
        queue.add(new Print(data[0][0], data[0][1], data[0][2]));

        while (currentTime <= totalTime) {
            if (map.containsKey(currentTime)) {
                queue.add(map.get(currentTime));
            }
            if (!queue.isEmpty() && currentTime >= nextStartTime) {
                Print p = queue.poll();
                answer[index] = p.pageNum;
                nextStartTime += p.length;
                index++;
            }

            currentTime++;
        }

        return answer;
    }

    class Print implements Comparable<Print> {

        int pageNum;
        int time;
        int length;

        public Print(int pageNum, int time, int length) {
            this.pageNum = pageNum;
            this.time = time;
            this.length = length;
        }

        @Override
        public int compareTo(Print o) {
            if (this.length < o.length) {
                return -1;
            } else if (this.length == o.length) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
