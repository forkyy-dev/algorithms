package baekjoon.goorm.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 퍼져나가는소문 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[][] follow = new boolean[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            follow[start][end] = true;
        }


        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int userNumber = q.poll();
            visited[userNumber] = true;
            for (int i = 2; i <= n; i++) {
                if (follow[userNumber][i] && !visited[i]) {
                    q.add(i);
                    answer++;
                }
            }

        }

        System.out.println(answer + 1);

    }

}
