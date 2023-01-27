package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21317 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] one = new int[n];
        int[] two = new int[n];
        int[] memo = new int[n];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            one[i] = Integer.parseInt(st.nextToken());
            two[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            memo[i] = 5500;
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < n - 1; i++) {
            memo[i + 1] = Math.min(memo[i] + one[i], memo[i + 1]);
            if (i == n - 2) {
                continue;
            }
            memo[i + 2] = Math.min(memo[i] + two[i], memo[i + 2]);
        }

        for (int i = 0; i < n - 3; i++) {
            int[] temp = new int[n];

            for (int l = 1; l < n; l++) {
                temp[l] = 5500;
            }

            for (int j = 0; j < n - 1; j++) {
                if (i == j) {
                    temp[j + 3] = Math.min(temp[j] + k, temp[j + 3]);
                } else {
                    temp[j + 1] = Math.min(temp[j] + one[j], temp[j + 1]);
                    if (j == n - 2) {
                        continue;
                    }
                    temp[j + 2] = Math.min(temp[j] + two[j], temp[j + 2]);
                }
            }

            if (memo[n - 1] > temp[n - 1]) {
                memo = temp;
            }
        }
        System.out.println(memo[n - 1]);

    }
}


/*
   if (n == 1) {
            System.out.println(0);
            return;
        }

        int[] one = new int[n + 1];
        int[] two = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            one[i] = Integer.parseInt(st.nextToken());
            if (i != n) {
                two[i + 1] = Integer.parseInt(st.nextToken());
            }
        }
        int k = Integer.parseInt(br.readLine());

        if (n == 2) {
            System.out.println(one[2]);
            return;
        }


        int[] memo = new int[n + 1];
        memo[2] = one[2];
        memo[3] = Math.min(memo[2] + one[3], memo[1] + two[3]);

        if (n == 3) {
            System.out.println(memo[3]);
            return;
        }

        for (int i = 4; i <= n; i++) {
            memo[i] = Math.min(memo[i - 1] + one[i], memo[i - 2] + two[i]);
        }

        for (int i = 4; i <= n; i++) {
            int[] temp = memo;
            for (int j = 4; j <= n; j++) {
                if (j == i) {
                    temp[j] = Math.min(temp[j], temp[j - 3] + k);
                }else{
                    temp[j] = Math.min(temp[j - 1] + one[j], temp[j - 2] + two[j]);
                }
            }
            memo[n] = Math.min(temp[n], memo[n]);
        }

        System.out.println(memo[n]);
    }

 */

/*
   if (n == 1) {
            System.out.println(0);
            return;
        }

        int[] one = new int[n + 1];
        int[] two = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            one[i] = Integer.parseInt(st.nextToken());
            if (i != n) {
                two[i + 1] = Integer.parseInt(st.nextToken());
            }
        }
        int k = Integer.parseInt(br.readLine());

        if (n == 2) {
            System.out.println(one[2]);
            return;
        }


        int[] memo = new int[n + 1];
        memo[2] = one[2];
        memo[3] = Math.min(memo[2] + one[3], memo[1] + two[3]);

        if (n == 3) {
            System.out.println(memo[3]);
            return;
        }

        for (int i = 4; i <= n; i++) {
            memo[i] = Math.min(memo[i - 1] + one[i], memo[i - 2] + two[i]);
        }

        for (int i = 4; i <= n; i++) {
            int[] temp = memo;
            for (int j = 4; j <= n; j++) {
                if (j == i) {
                    temp[j] = Math.min(temp[j], temp[j - 3] + k);
                }else{
                    temp[j] = Math.min(temp[j - 1] + one[j], temp[j - 2] + two[j]);
                }
            }
            memo[n] = Math.min(temp[n], memo[n]);
        }

        System.out.println(memo[n]);
    }

 */