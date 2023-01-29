package baekjoon;

import java.util.LinkedList;

public class FirstCache {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        LinkedList<String> cache = new LinkedList<>();

        for (String c : cities) {
            c = c.toLowerCase();

            if (!cache.contains(c)) {
                if (!(cache.size() < cacheSize)) {
                    cache.removeFirst();
                }
                cache.add(c);
                answer += 5;
            } else {
                cache.remove(c);
                cache.add(c);
                answer++;
            }
        }

        return answer;
    }
}

//List에 차례대로 노드를 넣는다.
//각각의 이미 중복된 노드가 있으면 해당 노드의 값에 +1 해준다.
//캐시가 꽉차면 리스트에서 가장 작은 값을 가진 노드를 찾아서 제거한다.
//