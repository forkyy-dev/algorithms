package programmers.codingtest.kakaomobility.test1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {
    public int solution(String[] id_list, int k) {
        int answer = 0;

        Map<String, Integer> users = new HashMap<>();

        for (String list : id_list) {
            String[] ids = list.split(" ");
            Set<String> set = new HashSet<>();

            for (String id : ids) {
                set.add(id);
            }

            for (String id : set) {
                if (users.containsKey(id)) {
                    if (users.get(id) < k) {
                        users.put(id, users.get(id) + 1);
                    }
                }else{
                    users.put(id, 1);
                }
            }
        }

        for (Integer value : users.values()) {
            answer += value;
        }
        return answer;
    }
}
