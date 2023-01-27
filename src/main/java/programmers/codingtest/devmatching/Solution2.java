package programmers.codingtest.devmatching;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution2 {

    public static int[] x = {-1, 1, 0, 0};
    public static int[] y = {0, 0, -1, 1};
    public static int maxX;
    public static int maxY;
    public static String[][] map;
    public static boolean[][] visited;
    public static Map<String, Integer> total;

    public int solution(String[] maps) {
        int answer = 0;

        map = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        maxX = maps.length-1;
        maxY = maps[0].length()-1;

        for (int i = 0; i < maps.length; i++) {
            String[] c = maps[i].split("");
            for (int j = 0; j < c.length; j++) {
                map[i][j] = c[j];
            }
        }

        total = new HashMap<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                if (!visited[i][j]) {
                    Map<String, Integer> result = bfs(i, j, new HashMap<>());

                }
            }
        }

        return answer;
    }

    public Map<String, Integer> bfs(int r, int c, Map<String, Integer> m) {
        Queue<String> q = new LinkedList<>();
        q.add(map[r][c]);

        while (!q.isEmpty()) {
            String country = q.poll();
            visited[r][c] = true;
            if (m.containsKey(country)) {
                m.put(country, m.get(country) + 1);
            }else{
                m.put(country, 1);
            }

            if (total.containsKey(country)) {
                total.put(country, total.get(country) + 1);
            }else{
                total.put(country, 1);
            }

            for (int i = 0; i < 4; i++) {
                int newR = r + x[i];
                int newC = r + y[i];

                if (newR >= 0 && newR <= maxX && newC >= 0 && newC <= maxY) {
                    bfs(newR, newC, m);
                }
            }
        }

        return m;
    }
}

//위 아래로