package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Divisor {
    public int[] solution(int[] arr, int divisor) {

        int[] result = Arrays.stream(arr).sorted().filter(s->s%divisor==0).toArray();
        if(result.length==0){
            return new int[]{-1};
        }
        return result;

//        List<Integer> list = new ArrayList<>();
//
//        Arrays.sort(arr);
//        for(int i=0; i<arr.length; i++){
//            if(arr[i]%divisor==0){
//                list.add(arr[i]);
//            }
//        }
//
//        if(list.size()==0){
//            return new int[]{-1};
//        }
//        int[] answer = new int[list.size()];
//        for(int i=0; i<list.size(); i++){
//            answer[i] = list.get(i);
//        }
//        return answer;
    }
}
