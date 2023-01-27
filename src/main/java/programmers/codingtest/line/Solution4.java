package programmers.codingtest.line;

public class Solution4 {
    public int[][] solution(String[] wall) {
        int[][] map = createMap(wall);



        return map;
    }

    private int[][] createMap(String[] wall) {
        int[][] map = new int[wall.length][wall[0].length()];
        for (int i = 0; i < wall.length; i++) {
            String[] row = wall[i].split("");
            for (int j = 0; j < row.length; j++) {
                String status = row[i];
                if (status.equals("H")) {
                    map[i][j] = 1;
                } else if (status.equals(".")) {
                    map[i][j] = 0;
                }else{
                    map[i][j] = -1;
                }
            }
        }
        return map;
    }
}

//클라이밍

//제한사항
//상하좌우의 홀드로 이동 가능
//좌우로 2,3칸 떨어진 곳은
//1. 두 홀드의 바로 위쪽 칸들
//2. 두 홀드가 위치한 칸을 직선으로 이었을때 지나는 칸
//3. 2번의 칸들의 위쪽 칸들
//이 모두 비어야함

//바로 위쪽 칸이 빈칸일 경우 위쪽으로 2칸 떨어진 홀드로 이동할 수 있음.
//왼쪽 위에 위치한 홀드로 가려면 바로 왼칸, 바로 위칸이 빈칸이어야함
//오른쪽 위에 위치한 홀드로 가려면 바로 오른칸, 바로 위칸이 빈칸이어야함

//시작지점에서 각 홀드까지에 대한 최단경로를 2차원 배열에 해당 홀드 자리에 넣어서 반환/ 접근 불가능 홀드는 -1로

//다익스트라로 도전..?