package programmers.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Pokemon {
    public int solution(int[] nums) {

        int max = nums.length/2;

        int types =(int) Arrays.stream(nums).distinct().count();


        return max < types ? max : types;
    }
}

//nums/2개의 개수를 뽑을 수 있다. -> 최대값.
//배열에서 중복값을 제거한 길이를 가져온다. -> 종류의 개수
//최대값보다 종류가 많을경우 최대값을 반환
//최대값보다 종류가 적을경우 종류를 반환
