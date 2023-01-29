package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfNotContainedNumber {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] answers = {0,1,2,3,4,5,6,7,8,9};
        List<Integer> list = new ArrayList<>();
        for(int n : numbers){
            list.add(n);
        }

        for(int num : answers){
            if(!list.contains(num)){
                answer+= num;
            }
        }

        return answer;
    }
}


//1 ≤ numbers의 길이 ≤ 9
//0 ≤ numbers의 모든 수 ≤ 9