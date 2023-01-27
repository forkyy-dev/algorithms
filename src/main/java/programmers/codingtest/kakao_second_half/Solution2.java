package programmers.codingtest.kakao_second_half;

public class Solution2 {

    public static int[] d;
    public static int[] p;
    public static boolean[] deliveryStatus;
    public static boolean[] pickupStatus;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        d = deliveries.clone();
        p = pickups.clone();
        deliveryStatus = new boolean[n];
        pickupStatus = new boolean[n];

        while (true) {

            int capStatus = cap;
            boolean status = false;
            for (int i = 0; i < n; i++) {
                if (d[i] != 0 || p[i] != 0) {
                    status = true;
                    break;
                }
            }

            if (!status) {
                break;
            }

            for (int i = n-1; i >= 0; i--) {
                if (d[i]!= 0 && d[i] + capStatus <= cap) {
                    int temp = p[i];
                    d[i] -= cap - capStatus;
                    capStatus -= temp;
                }
                if (p[i] != 0 && p[i] + capStatus <= cap) {
                    int temp = p[i];
                    p[i] -= cap - capStatus;
                    capStatus += temp;
                }
            }
        }





        return answer;
    }

}
