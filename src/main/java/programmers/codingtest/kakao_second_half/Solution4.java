package programmers.codingtest.kakao_second_half;

public class Solution4 {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String convertedNumber = Integer.toString((int) numbers[i], 2);

            int midIndex = convertedNumber.length() / 2;

        }

        return answer;
    }
}
