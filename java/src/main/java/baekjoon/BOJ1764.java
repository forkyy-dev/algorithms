package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        List<String> l = new ArrayList<>();

        for (int i = 0; i < n + m; i++) {
            l.add(br.readLine());
        }

        Collections.sort(l);

        List<String> a = new ArrayList<>();
        for (int i = 0; i < n + m - 1; i++) {
            if (l.get(i).equals(l.get(i + 1))) {
                a.add(l.get(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(a.size()).append('\n');

        for (String name : a) {
            sb.append(name).append('\n');
        }

        System.out.println(sb);
    }
}
