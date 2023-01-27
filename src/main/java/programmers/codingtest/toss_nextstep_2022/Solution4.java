package programmers.codingtest.toss_nextstep_2022;

import java.util.*;

public class Solution4 {

    Map<Long, List<Long>> map = new HashMap<>();
    Map<Long, Long> scores = new HashMap<>();

    public long[] solution(long[][] invitationPairs) {
        long[] answer = {};

        for (long[] pair : invitationPairs) {
            long key = pair[0];
            long val = pair[1];

            map.get(key).add(val);
            scores.put(key, 0L);
        }


        for (Long key : map.keySet()) {
            dfs(key, 0, 0);
        }


        return answer;
    }

    public void dfs(long key, int score, int depth) {
        if (depth == 4) {
            return;
        }

        Queue q = new LinkedList();


    }
}
