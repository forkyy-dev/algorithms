package programmers.level2;

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            if (citations[i]>=citations.length - i) {
                return citations.length-i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        HIndex s = new HIndex();
        System.out.println(s.solution(new int[]{1,4,6,9,10,100}));
    }

}


//1. 배열을 정렬한다.
//2. 앞에서부터 h를 갱신한다.
