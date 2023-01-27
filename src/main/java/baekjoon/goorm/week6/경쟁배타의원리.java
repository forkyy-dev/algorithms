package baekjoon.goorm.week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경쟁배타의원리 {

    static int n, k;
    static int[][] map = new int[1001][1001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            map[y1][x1] += 1;
            map[y1][x2] -= 1;
            map[y2][x1] -= 1;
            map[y2][x2] += 1;
        }

        for (int i = 0; i < 1001; i++) {
            for (int j = 1; j < 1001; j++) {
                map[i][j] += map[i][j - 1];
            }
        }

        for (int i = 0; i < 1001; i++) {
            for (int j = 1; j < 1001; j++) {
                map[j][i] += map[j - 1][i];
            }
        }

        int answer = 0;

        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                if (map[i][j] == k) {
                    answer++;
                }
            }
        }
        System.out.println(answer);

    }

}

/*
3 4
1 1 4 R4
4476
3387


1 1 5 5 -> 1번 서식종
4 4 7 6 -> 2번 서식종
3 3 8 7 -> 3번 서식종

- 1000 사이즈의 map을 만든다.
- 종의 누적합을 저장.
- 1000을 순회하면서 k 이상인 좌표의 개수를 구한다.

 */