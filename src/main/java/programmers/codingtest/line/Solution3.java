package programmers.codingtest.line;

public class Solution3 {
    public long[][] solution(int n, int m, int[][] fires, int[][] ices) {
        long[][] map = new long[n + 1][n + 1];




        return map;
    }
}

//n * n 형태의 정사각형 마을
//m분 후의 각 칸의 온도를 담은 2차원 배열 반환
//불꽃 토템 -> 1분에 상하좌우 1줄씩 범위 증가(정사각형 모양으로)
//얼음 토템 -> 1분에 상하좌우 1,3,5... 형태로 범위 증가

//제한사항
//1 <= n <= 30
//1 <= m <= 1,000,000,000
//1 <= fires, ices.length <= n

