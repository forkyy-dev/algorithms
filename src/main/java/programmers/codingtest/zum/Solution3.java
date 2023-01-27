package programmers.codingtest.zum;

public class Solution3 {
    public int solution(int[] histogram) {
        int answer = -1;

        int start = 0;
        int end = histogram.length - 1;

        while (start < end) {

            int width = end - start - 1;
            int height = Math.min(histogram[start], histogram[end]);
            int size = width * height;

            answer = Math.max(answer, size);

            if (histogram[start] < histogram[end]) {
                start++;
            }else{
                end--;
            }
        }

        return answer;
    }
}
