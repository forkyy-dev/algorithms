package programmers.codingtest.kakaomobility.test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

    private static int[] counts;
    private static int x;

    public int solution(int n, int[][] edges, int[] users, int d, int limit) {

        counts = new int[n + 1];
        x = d;

        Map<Integer, List<Edge>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i + 1, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int length = edge[2];
            map.get(start).add(new Edge(end, length));
        }



        int answer = 0;
        return answer;
    }

    public void bfs(int start, int distance) {

    }

    class Edge {
        int destination;
        int x;

        public Edge(int destination, int x) {
            this.destination = destination;
            this.x = x;
        }
    }
}

/*
- 각 지점에서 다른 지점까지 갈 수 있는 거리를 가지고 있어야 함.
- 유저가 있는 위치부터 d거리에 있는 지점들을 파악.
- 각 위치에서 몇군데로 이동할 수 있는가?
 */