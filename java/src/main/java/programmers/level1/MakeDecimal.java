package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class MakeDecimal {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i=0; i<nums.length; i++){
            if(i+2 > nums.length){
                break;
            }
            for(int j=i+1; j< nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(prime(nums[i] + nums[j] + nums[k])){
                        answer++;
                    };
                }
            }
        }

        return answer;
    }

    public boolean prime(int n){
        if(n<2){
            return false;
        }
        for(int i=2; i<n-1; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}


//삼중 for문으로 3개씩 더한 값을 저장한다.