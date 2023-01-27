package programmers.level1;

public class 로또의_최고순위와_최저순위 {

    public int[] solution(int[] lottos, int[] win_nums) {

        int answerCnt = 0;
        int errorCnt = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                errorCnt++;
            }else{
                for (int win_num : win_nums) {
                    if (win_num == lotto) {
                        answerCnt++;
                        break;
                    }
                }
            }
        }

        return new int[]{7 - Math.max(1, answerCnt + errorCnt), 7 - Math.max(1, answerCnt)};
    }

}
