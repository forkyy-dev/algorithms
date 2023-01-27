package programmers.codingtest.devmatching;

public class Solution3 {

    public static int[] numbers = new int[10];

    public long solution(int k) {

        numbers[0] = 6;
        numbers[1] = 2;
        numbers[2] = 5;
        numbers[3] = 5;
        numbers[4] = 4;
        numbers[5] = 5;
        numbers[6] = 6;
        numbers[7] = 3;
        numbers[8] = 7;
        numbers[9] = 6;


        int[] dp = new int[51];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 1;
        dp[5] = 3;
        dp[6] = 2;


        for (int i = 10; i < Integer.MAX_VALUE; i++) {
            String s = String.valueOf(i);
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                count += numbers[j];
            }
            dp[count]++;
        }

        return dp[k];
    }
}

//0~9까지 필요한 성냥 개수 배열에 저장해둔다.
//해당 개수의 성냥개비로 만들 수 있는 조합을 구할것.
//12 => 7개 필요
//50을 피보나치 수열로 나누면