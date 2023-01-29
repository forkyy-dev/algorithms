package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 {

    static int n, m, v;
    static boolean[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");

        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        v = Integer.parseInt(s[2]);

        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String[] k = sc.nextLine().split(" ");

            int start = Integer.parseInt(k[0]);
            int end = Integer.parseInt(k[1]);

            graph[start][end] = true;
            graph[end][start] = true;
        }

        visited[v] = true;
        dfs(v);
        System.out.println(sb);

        visited = new boolean[n + 1];
        sb.setLength(0);
        bfs(v);
        System.out.println(sb);
    }

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start);

        for (int i = 1; i <= n; i++) {
            if (graph[start][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();
            sb.append(poll);
            for (int i = 1; i <= n; i++) {
                if (graph[poll][i] && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

    }

}

//DFS => DSLR - 스택 및 재귀
//BFS => BBQ -> 큐
