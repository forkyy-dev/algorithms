package programmers.kakao.blind2022;

public class 양궁대회 {

    private static int max = -1000;
    private static int chance;
    private static int[] peach;
    private static int[] lion;
    private static int[] answer = {-1};


    public int[] solution(int n, int[] info) {

        chance = n;
        peach = info;
        lion = new int[11];

        dfs(1);

        return answer;
    }

    public void dfs(int count) {
        if (count == chance + 1) {
            int peachScore = 0;
            int lionScore = 0;
            for (int i = 0; i <= 10; i++) {
                int peachCount = peach[i];
                int lionCount = lion[i];
                if (peachCount == 0 && lionCount == 0) {
                    continue;
                }
                if (lionCount > peachCount) {
                    lionScore += 10 - i;
                } else {
                    peachScore += 10 - i;
                }
            }
            if (lionScore > peachScore) {
                if (max <= lionScore - peachScore) {
                    max = lionScore - peachScore;
                    answer = lion.clone();
                }
            }
            return;
        }

        for (int i = 0; i <= 10 && lion[i] <= peach[i]; i++) {
            lion[i]++;
            dfs(count + 1);
            lion[i]--;
        }
    }

}

//n = 쏘는 회수
//k = 과녁의 점수

//더 많이 맞춘 사람에게 점수가 주어짐. (동점 시 어피치한테)
//모든 과녁에 대한 점수 계산 후 우승자 반환 (동점 시 어피치)

//각 점수에 대해서 어피치가 쏜 값+1까지 가져오도록 할것.
//10점부터 시작해서 이길 수 있는 경우의 수 다 돌리기.
//하나의 점수를 버리는 경우로?
//화살을 모두 다 쓰게 되면 정지
//이때 점수차이가 더 큰지 비교해서 큰 경우 해당 배열로 설정
//차이가 같으면 낮은 점수 개수 비교

//dfs
//