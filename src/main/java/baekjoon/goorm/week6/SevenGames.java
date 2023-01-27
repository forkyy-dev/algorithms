package baekjoon.goorm.week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SevenGames {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int j = 0; j < 5; j++) {
            String[] input = br.readLine().split("");

            int a = 0;
            for (int i = 0; i < 7; i += 2) {
                a += Integer.parseInt(input[i]);
            }

            for (int i = 1; i < 7; i += 2) {
                int n = Integer.parseInt(input[i]);
                if (n != 0) {
                    a *= n;
                }
            }
            System.out.println(a % 10);
        }

    }
}
/*
5,7,9,5 -> a : 26
8,4 -> 26 * 8 * 4 : 832


 */