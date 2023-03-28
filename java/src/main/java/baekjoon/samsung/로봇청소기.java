package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int n, m;
    static int direction;
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String[] nums = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(nums[j]);
            }
        }

        clean(r, c);
        System.out.println(answer);

    }

    public static void clean(int curR, int curC) {
        map[curR][curC] =-1;

        for (int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4;
            int x = curR + dx[direction];
            int y = curC + dy[direction];

            if (x >= 0 && x < n && y >= 0 && y < m && map[x][y] == 0){
                answer++;
                clean(x, y);
                return;
            }
        }
        int rollback = (direction + 2) % 4;

        int nx = curR + dx[rollback];
        int ny = curC + dy[rollback];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 1) {
            clean(nx, ny);
        }
    }
}


/*

if(map[x][y] != cleaned){
    clean;
}

for(int i = 0; i < 4; i++) {
    if(모두 벽이다, 더이상 갈 수 없다){
        if(후진 가능){
            후진.
            continue;
        } else {
            break;
        }
    }

    if(청소되지 않았다.){
        바라보는 방향 %= 4;
        check

    }

}

 */