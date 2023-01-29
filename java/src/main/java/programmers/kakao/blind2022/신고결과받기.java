package programmers.kakao.blind2022;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class 신고결과받기 {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        신고결과받기 app = new 신고결과받기();
        app.solution(id_list, report, k);
    }

    public int[] solution(String[] id_list, String[] report, int k) {

        Map<String, Integer> reportCount = new LinkedHashMap<>();
        Map<String, Set<String>> reportMap = new LinkedHashMap<>();

        for (String name : id_list) {
            reportCount.put(name, 0);
            reportMap.put(name, new HashSet<>());
        }

        for (String r : report) {
            String[] names = r.split(" ");
            String reporter = names[0];
            String target = names[1];

            if (!reportMap.get(reporter).contains(target)) {
                reportCount.put(target, reportCount.get(target) + 1);
                reportMap.get(reporter).add(target);
            }
        }

        List<String> collect = reportCount.entrySet().stream()
            .filter(e -> e.getValue() >= k)
            .map(Entry::getKey)
            .collect(Collectors.toList());

        List<Integer> l = reportMap.values().stream()
            .map(reports -> {
                int count = 0;
                for (String name : collect) {
                    if (reports.contains(name)) {
                        count++;
                    }
                }
                return count;
            })
            .collect(Collectors.toList());

        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = l.get(i);
        }

        return answer;
    }
}

//유저별로 자신이 신고한 유저 목록을 가진다. -> HashSet
//각 유저별로 신고목록을 돌며 각 유저가 신고받은 횟수를 추가한다.
