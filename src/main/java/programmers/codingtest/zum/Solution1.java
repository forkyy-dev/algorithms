package programmers.codingtest.zum;

public class Solution1 {

    public long solution(long n) {
        long answer = 0;

        long length = n - 1;

        for (int i = 1; i <= length; i++) {
            answer += (n + 1) * i;
        }

        return answer;
    }

}
