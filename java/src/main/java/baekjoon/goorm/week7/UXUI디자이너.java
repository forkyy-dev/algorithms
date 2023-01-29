package baekjoon.goorm.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class UXUI디자이너 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int e = Integer.parseInt(st.nextToken());
                if (counts.containsKey(e)) {
                    counts.put(e, counts.get(e) + 1);
                }else{
                    counts.put(e, 1);
                }
            }
        }

        int max = counts.values().stream().max(Comparator.comparingInt(a -> a)).get();

        List<Integer> result = counts.entrySet().stream().filter((s) -> s.getValue() == max)
            .map(Entry::getKey)
            .sorted((a, b) -> b - a)
            .collect(Collectors.toList());

        if (result.size() == 1) {
            System.out.println(result.get(0));
        }else{
            StringBuilder sb = new StringBuilder();
            for (int num : result) {
                sb.append(num + " ");
            }
            System.out.println(sb.toString());

        }

    }

}
