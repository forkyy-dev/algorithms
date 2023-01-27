package programmers.level2;

public class 피로도 {
    public static int answer = -1;
    public static boolean[] visited;
    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);

        return answer;
    }

    public static  void dfs(int num, int k, int[][]dungeons) {

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(num + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, num);
    }
}

//던전 개수만큼 for문을 통해 여러 조합으로 던전을 돈다.
//방문하지 않았고, 던전에 현재 체력이 요구체력보다 높으면 돈다.

