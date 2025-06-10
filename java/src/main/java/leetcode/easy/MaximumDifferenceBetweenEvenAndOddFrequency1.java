package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MaximumDifferenceBetweenEvenAndOddFrequency1 {
    public int maxDifference(String s) {
        // Map<Character, Integer> m = new HashMap<>();

        // for (char c : s.toCharArray()) {
        //     if (!m.containsKey(c)) {
        //         m.put(c, 1);
        //     } else {
        //         m.put(c, m.get(c) + 1);
        //     }
        // }

        // int oddMax = 0;
        // int evenMax = Integer.MAX_VALUE;

        // for (int v : m.values()) {
        //     if (v % 2 == 0) {
        //         evenMax = Math.min(evenMax, v);
        //     } else {
        //         oddMax = Math.max(oddMax, v);
        //     }
        // }


        // return oddMax - evenMax;

        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        int om = 0;
        int em = s.length();

        for (int i : arr) {
            if (i % 2 == 0) {
                em = i ==0 ? Math.min(em, s.length()) : Math.min(em, i);
            } else {
                om = Math.max(om, i);
            }
        }

        return om - em;
    }
}
