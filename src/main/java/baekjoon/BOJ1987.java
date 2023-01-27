package baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ1987 {

    static int[] rowDirection = {0, -1, 0, 1};
    static int[] columnDirection = {-1, 0, 1, 0};
    static char[][] graph;
    static int r, c;
    static Set<Character> set = new HashSet<>();
    static int result = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();

        sc.nextLine();

        graph = new char[r][c];

        for (int i = 0; i < r; i++) {
            String words = sc.nextLine();
            for (int j = 0; j < c; j++) {
                graph[i][j] = words.charAt(j);
            }
        }

        set.add(graph[0][0]);

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int row, int column) {
        int result = 1;

        for (int i = 0; i < 4; i++) {

            int nextRow = row + rowDirection[i];
            int nextColumn = column + columnDirection[i];

            if (nextRow < 0 || nextColumn < 0 || nextRow >= c || nextColumn >= r) {
                continue;
            }
            if (!set.contains(graph[nextColumn][nextRow])) {
                set.add(graph[nextColumn][nextRow]);
                result += dfs(nextRow, nextColumn);
            }

        }
        return result;
    }
}
