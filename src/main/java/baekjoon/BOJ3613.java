package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3613 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s.length() == 0 || s.equals(" ") || s.startsWith("_") || s.endsWith("_")) {
            System.out.println("Error!");
            return;
        }

        if (s.charAt(0) >= 65 && s.charAt(0) <= 90) {
            System.out.println("Error!");
            return;
        }

        StringBuilder sb = new StringBuilder();

        //C++
        if (s.contains("_")) {
            String[] words = s.split("_");

            for (int i = 0; i < words.length; i++) {
                if (words[i].equals("")) {
                    System.out.println("Error!");
                    return;
                }
                String[] splitWords = words[i].split("");
                for (int j = 0; j < splitWords.length; j++) {
                    int point = splitWords[j].codePointAt(0);
                    if (point >= 65 && point <= 90) {
                        System.out.println("Error!");
                        return;
                    }
                    if (i == 0) {
                        sb.append(splitWords[j]);
                        continue;
                    }
                    if (j == 0) {
                        sb.append(splitWords[j].toUpperCase());
                        continue;
                    }
                    sb.append(splitWords[j]);
                }
            }
        } else {
            //java
            String[] words = s.split("");
            for (int i = 0; i < words.length; i++) {
                int point = words[i].codePointAt(0);
                if (point >= 65 && point <= 90) {
                    sb.append("_");
                    sb.append(words[i].toLowerCase());
                    continue;
                }
                sb.append(words[i]);
            }
        }
        System.out.println(sb);
    }
}
