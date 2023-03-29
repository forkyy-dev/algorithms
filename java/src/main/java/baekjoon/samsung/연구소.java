package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 연구소 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int answer = 0;
    static int[][] map;
    static List<int[]> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] nums = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(nums[j]);
                if (map[i][j] == 2) {
                    int[] point = {i, j};
                    virus.add(point);
                }
            }
        }
        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int walls) {
        if (walls == 3) {
            check();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(walls + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void check() {
        Queue<int[]> q = new LinkedList<>(virus);
        int[][] temp = Arrays.stream(map)
            .map(int[]::clone)
            .toArray(int[][]::new);

        while (!q.isEmpty()) {
            int[] point = q.poll();
            temp[point[0]][point[1]] = 2;
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && temp[nx][ny] == 0) {
                    int[] nextPoint = {nx, ny};
                    q.add(nextPoint);
                }

            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }

}
