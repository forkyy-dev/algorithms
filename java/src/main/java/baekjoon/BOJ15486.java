package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15486 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n];
        int[] p = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int maxNumber = -1;

        for (int i = 0; i < n; i++) {
            if (maxNumber < dp[i]) {
                maxNumber = dp[i];
            }

            if (i + t[i] < n) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], maxNumber + p[i]);
            }

        }
        System.out.println(dp[n - 1]);

    }

}
