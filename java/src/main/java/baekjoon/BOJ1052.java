package baekjoon;

import java.util.Scanner;

public class BOJ1052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int answer = 0;

        while (true) {
            if (helper(n++) <= k) break;
            answer++;
        }
        System.out.println(answer);
    }

    public static int helper(int num){
        int result = 0;
        while (!(num<1)) {
            if (num % 2 == 1) result++;
            num /= 2;
        }
        return result;
    }
}
