package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600 {

    private static final int[] mx = {0, 1, 0, -1};
    private static final int[] my = {1, 0, -1, 0};
    private static final int[] hx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] hy = {-1, 1, -2, 2, -2, 2, -1, 1};
    private static int[][] map;
    private static boolean[][][] visited;
    private static int k;
    private static int h;
    private static int w;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new boolean[h][w][k + 1];

        for (int i = 0; i < h; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        System.out.println(bfs(0, 0));


    }

    public static int bfs(int x, int y) {
        Queue<Monkey> queue = new LinkedList<>();
        queue.offer(new Monkey(x, y, k, 0));
        visited[x][y][0] = true;

        while (!queue.isEmpty()) {
            Monkey monkey = queue.poll();

            if (monkey.isEnd()) {
                return monkey.count;
            }

            for (int i = 0; i < 4; i++) {
                int newX = monkey.x + mx[i];
                int newY = monkey.y + my[i];

                if (newX >= 0 && newX < w && newY >= 0 && newY < h && !visited[newX][newY][monkey.k]
                    && map[newX][newY] != 1) {
                    visited[newX][newY][monkey.k] = true;
                    queue.add(new Monkey(newX, newY, monkey.k, monkey.count + 1));
                }
            }
            if (monkey.k < k) {
                for (int i = 0; i < 8; i++) {
                    int newX = monkey.x + hx[i];
                    int newY = monkey.y + hy[i];

                    if (newX >= 0 && newX < w && newY >= 0 && newY < h
                        && !visited[newX][newY][monkey.k]
                        && map[newX][newY] != 1) {
                        visited[newX][newY][monkey.k - 1] = true;
                        queue.add(new Monkey(newX, newY, monkey.k - 1, monkey.count + 1));
                    }
                }
            }
        }

        return -1;
    }

    static class Monkey {

        int x;
        int y;
        int k;
        int count;

        public Monkey(int x, int y, int k, int count) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.count = count;
        }

        public boolean isEnd() {
            return x == h - 1 && y == w - 1;
        }
    }

}

// 말의 움직임 : 상or하2 + 좌or우 1 / 좌or우2 + 상or하1
// 원숭이는 k번만 말처럼 / 이후에는 상하좌우로만 이동가능
// 0은 갈수있는 곳, 1은 장애물