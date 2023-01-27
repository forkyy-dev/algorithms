package programmers.codingtest.toss_nextstep_2022;

public class Solution2 {
    public int solution(int[] levels) {
        int answer = 0;

        int length = levels.length;
        int round = (int) Math.floor(length / 4);
        int i = length - round;

        return levels[i];
    }
}
