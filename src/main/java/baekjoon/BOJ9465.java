package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9465 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int caseLength = Integer.parseInt(br.readLine());
            int[][] arr = createArray(br, caseLength);
            int[][] dp = new int[2][caseLength];

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            dp[0][1] = arr[1][0] + arr[0][1];
            dp[1][1] = arr[0][0] + arr[1][1];

            if (caseLength == 1) {
                System.out.println(Math.max(dp[0][0], dp[1][0]));
                continue;
            }

            for (int j = 2; j < caseLength; j++) {
                dp[0][j] = Math.max(Math.max(dp[0][j - 2] + arr[0][j], dp[1][j - 2] + arr[0][j]),
                    dp[1][j - 1] + arr[0][j]);
                dp[1][j] = Math.max(Math.max(dp[0][j - 2] + arr[1][j], dp[1][j - 2] + arr[1][j]),
                    dp[0][j - 1] + arr[1][j]);
            }
            System.out.println(Math.max(dp[0][caseLength - 1], dp[1][caseLength - 1]));
        }


    }

    private static int[][] createArray(BufferedReader br, int caseLength) throws IOException {
        int[][] arr = new int[2][caseLength];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < caseLength; i++) {
            arr[0][i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < caseLength; i++) {
            arr[1][i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}