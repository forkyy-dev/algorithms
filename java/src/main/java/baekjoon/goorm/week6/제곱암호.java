package baekjoon.goorm.week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 제곱암호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String secret = br.readLine();

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i += 2) {
            int code = secret.charAt(i);
            int number = Integer.parseInt(String.valueOf(secret.charAt(i + 1)));
            number = (int) Math.pow(number, 2);

            while (number > 26) {
                number %= 26;
            }

            code += number;

            if (code > 122) {
                code = code - 26;
            }
            answer.append((char)code);
        }

        System.out.println(answer.toString());

    }
}

/*
n길이의 암호문 /-> 숫자 반, 소문자 반 / 항상 짝수
z2y2z1
문자열 뒤에 오는 숫자의 제곱번 문자 넘기기. -> z일 경우 a로

해당 알파벳의 ascii code를 가지고 범위 내에서 돌리기
97 ~ 122

 */