package programmers.codingtest.kakaobank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Solution3 {

    public static void main(String[] args) {
        Solution3 app = new Solution3();
        System.out.println(app.solution(new int[]{3, 1, 2, 4}));;
        System.out.println(app.solution(new int[]{2, 3, 4, 5, 1}));;
        System.out.println(app.solution(new int[]{1, 2, 3, 4, 5, 6}));;
    }

    public int solution(int[] rooms) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < rooms.length; i++) {
            int room = rooms[i];
            map.put(i + 1, room);
        }

        boolean[] visited = new boolean[rooms.length + 1];
        List<Set<Integer>> list = new ArrayList<>();

        for (int i = 0; i < rooms.length; i++) {
            int cur = i + 1;
            Set<Integer> set = new HashSet<>();

            while (cur < visited.length && !visited[cur]) {
                visited[cur] = true;
                set.add(cur);
                cur = map.get(cur);
            }

            if (!set.isEmpty()) {
                list.add(set);
            }
        }

        if (list.size() < 3) {
            return 1;
        }else{
            return list.size() - 1;
        }
    }
}

/*
1 ~ n까지의 방과 열쇠 있음
방에 해당하는 열쇠로만 열림
마스터 키로 몇개의 방을 열어두려고 함.

최소 몇개를 열어야 마스터 키 없이 다른 방을 열수 있는지. -> 마스터키로 열어둬야하는 최소한의 방개수
딱 한번만 하나의 방을 골라 해당 방에 놓여있는 열쇠를 다른 번호의 열쇠로 교체할 수 있음

[3, 1, 2, 4]
1번방에 3번 열쇠
2번방에 1번 열쇠
...

 */