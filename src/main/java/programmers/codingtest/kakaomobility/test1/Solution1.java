package programmers.codingtest.kakaomobility.test1;

public class Solution1 {
    public int solution(int[][] flowers) {
        int answer = 0;

        int[][] map = new int[flowers.length][366];

        for (int i = 0; i < flowers.length; i++) {
            int startDay = flowers[i][0];
            int endDay = flowers[i][1];

            for (int j = startDay; j < endDay; j++) {
                map[i][j] = 1;
            }
        }

        for (int i = 1; i < 366; i++) {
            for (int j = 1; j < map.length; j++) {
                map[j][i] += map[j-1][i];
            }
        }

        for (int i : map[map.length - 1]) {
            if (i > 0) {
                answer++;
            }
        }
        return answer;
    }
}

// 2차원 배열
// 가로 365
// 세로 flowers 길이
// 각각 돌면서 꽃이 피어있는 날만 1로 초기화
// 세로로 누적합 처리
// 맨 마지막 행을 돌면서 확인하기
