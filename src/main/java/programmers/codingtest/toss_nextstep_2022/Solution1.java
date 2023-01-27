package programmers.codingtest.toss_nextstep_2022;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public int solution(String s) {

        if(s.length() < 3) return -1;

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<s.length()-2; i++){
            char s1 = s.charAt(i);
            char s2 = s.charAt(i+1);
            char s3 = s.charAt(i+2);

            if (s1 == s2 && s2 == s3) {
                list.add(Integer.parseInt(String.valueOf(s1)));
            }
        }

        if(list.isEmpty()) return -1;

        list.sort((a,b) -> b-a);
        int answer = list.get(0);

        return answer * 100 + answer * 10 + answer;
    }
}
