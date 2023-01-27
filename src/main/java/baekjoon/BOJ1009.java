package baekjoon;

import java.util.Scanner;

public class BOJ1009 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testCaseLength = sc.nextInt();

        for (int i = 0; i < testCaseLength; i++) {
            int firstNumber = sc.nextInt();
            int secondNumber = sc.nextInt();
            int remainder = 1;
            for(int j = 0; j<secondNumber; j++){
                remainder = (remainder * firstNumber) % 10;
            }
            if(remainder == 0){
                System.out.println(10);
                continue;
            }
            System.out.println(remainder);
        }
    }
}