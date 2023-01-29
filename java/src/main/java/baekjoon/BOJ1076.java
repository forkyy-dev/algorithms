package baekjoon;

import java.util.Map;
import java.util.Scanner;

public class BOJ1076 {

    private static final Map<String, Integer> colorMap = Map.of(
        "black", 0,
        "brown", 1,
        "red", 2,
        "orange", 3,
        "yellow", 4,
        "green", 5,
        "blue", 6,
        "violet", 7,
        "grey", 8,
        "white", 9
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        String input3 = sc.nextLine();

        sb.append(colorMap.get(input1));
        sb.append(colorMap.get(input2));
        long answer = Integer.parseInt(sb.toString()) * (long) Math.pow(10, colorMap.get(input3));

        System.out.println(answer);
    }
}

