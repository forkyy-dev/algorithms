package programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

public class Tuple {
    public int[] solution(String s) {
        String newS = s.replaceAll("\\{", "").replaceAll("}", "");
        String[] arr = newS.split(",");
        Map<String, Integer> m = new HashMap<>();
        for (String s1 : arr) {
            if (m.containsKey(s1)) {
                int i = m.get(s1);
                m.replace(s1, i + 1);
            } else {
                m.put(s1, 1);
            }
        }

        int[] answer = new int[m.keySet().size()];

        List<Integer> list = m.keySet().stream()
                .sorted((a, b) -> m.get(b) - m.get(a))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }


        return answer;
    }
}


//1. 각 괄호를 기준으로 배열(리스트)을 만든다.
//2. 배열의 길이를 기준으로 정렬한다.
//3.각 리스트의 인덱스에 있는 값을 꺼낸다.

