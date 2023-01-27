package programmers.codingtest.kakaomobility.test2;

public class Solution1 {
    public static int steps;
    public static int maxWalkTime;
    public static int[][] map;

    public int solution(int[][] infos, int m) {

        steps = infos.length;
        map = infos;
        maxWalkTime = m;

        int car = 0;
        int walk = 0;

        //자동차
        for (int i = 0; i < steps; i++) {
            car += infos[i][0];
        }

        int bike = bikeHelper(infos[0][1], 1, 0);
        int bikeAndWalk = bikeHelper(infos[0][3], 1, infos[0][3]);
        int bicycle = Math.min(bike, bikeAndWalk);

        int busTime = busHelper(0, 0, 0);
        int busAndWalk = busHelper(infos[0][3], 1, infos[0][3]);
        int bus = Math.min(busTime, busAndWalk);

        for (int i = 0; i < steps; i++) {
            if (walk + infos[i][3] > maxWalkTime) {
                walk = Integer.MAX_VALUE;
                break;
            }
            walk += infos[i][3];
        }

        int answer = Math.min(Math.min(car, bicycle), Math.min(bus, walk));
        return answer;
    }

    public int bikeHelper(int n, int depth, int walkTime) {
        if (depth == steps) {
            return n;
        }

        int b = map[depth][1];
        int w = map[depth][3];

        if (b <= w) {
            return bikeHelper(n + b, depth + 1, walkTime);
        }else{
            if (walkTime + w <= maxWalkTime) {
                return bikeHelper(n + w, depth + 1, walkTime + w);
            }else{
                return bikeHelper(n + b, depth + 1, walkTime);
            }
        }
    }

    public int busHelper(int n, int depth, int walkTime) {
        if (depth == steps) {
            return n;
        }

        int b = map[depth][2];
        int w = map[depth][3];

        if (b != -1 && b <= w) {
            return busHelper(n + b, depth + 1, walkTime);
        } else {
            if (walkTime + w <= maxWalkTime) {
                return busHelper(n + w, depth + 1, walkTime + w);
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

}

/*
구간의 개수 == infos.length
자동차 = infos[i][0]
자전거 = infos[i][1]
대중교통 = infos[i][2]
도보 = infos[i][3]

자동차 시간은 고정
자전거 : 자전거로 시작 vs 도보로 시작 => 그리디로
대중교통도 마찬가지 but -1이면 도보로 이동
도보 : 도보로만 가다가 m에 걸리면 끝

 */