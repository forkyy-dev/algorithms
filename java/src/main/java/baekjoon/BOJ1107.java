package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class BOJ1107 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);

        int destination = sc.nextInt();
        int n = sc.nextInt();

        boolean[] brokenNums = new boolean[10];

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            brokenNums[num] = true;
        }

        int result = Math.abs(destination - 100);

        for (int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);
            boolean status = false;

            for (int j = 0; j < num.length(); j++) {
                if (brokenNums[num.charAt(j) - '0']) {
                    status = true;
                    break;
                }
            }
            if (!status) {
                int c = Math.abs(destination - i) + num.length();
                result = Math.min(result, c);
            }
        }
        System.out.println(result);
    }
}

//1. 망가진 번호 목록을 받아서 boolean 타입의 배열에 해당 번호 위치를 true로 변경한다.
//2. 목표 채널에서 각 자리수에 대해 덧셈, 뺄셈을 해서 위아래로 가장 차이가 적게 나는 숫자를 찾는다
//3. 두 숫자의 차이를 비교해서 더 적게 나는 숫자를 누르고, 남은 숫자만큼 +를 눌러준다.
