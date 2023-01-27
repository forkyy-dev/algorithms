package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PopSum {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(!list.contains(numbers[i]+numbers[j])){
                    list.add(numbers[i]+numbers[j]);
                }
            }
        }
        return  list.stream().sorted().mapToInt(s->s).toArray();
    }

    public static void main(String[] args) {
        PopSum s = new PopSum();
        s.solution(new int[]{1,2});
    }
}
