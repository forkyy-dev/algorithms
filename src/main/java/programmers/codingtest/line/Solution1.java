package programmers.codingtest.line;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int solution(int[][] queries) {
        int answer = 0;

        Map<Integer, int[]> arrays = new HashMap<>();

        for (int[] query : queries) {
            int target = query[0];
            int itemsCount = query[1];

            if (!arrays.containsKey(target)) {
                int arrMaxSize = calculateSize(itemsCount);
                arrays.put(target, new int[]{itemsCount, arrMaxSize});
                continue;
            }

            int[] counts = arrays.get(target);
            int curCount = counts[0];
            int curSize = counts[1];

            if (curCount + itemsCount > curSize) {
                answer += curCount;
                int newMaxSize = calculateSize(curSize);
                arrays.put(target, new int[]{curCount + itemsCount, newMaxSize});
            }else{
                arrays.put(target, new int[]{curCount + itemsCount, curSize});
            }
        }

        return answer;
    }

    public int calculateSize(int number) {
        if (number == 1) {
            return number;
        }
        int newPow = (int) (Math.log(number) / Math.log(2)) + 1;
        return (int) Math.pow(2, newPow);
    }

}


//배열에 원소 추가하는 작업
//새로운 배열로 복사하는 경우 다음 길이는 2의 거듭제곱 중 작은것. ex) 10개면 -> 16길이의 배열 생성
//쿼리에는 몇번 배열에 몇개의 데이터가 추가되는지 들어있음 ex) 2,10 / 2,9 -> a <= 1000, b <= 10,000
//원소가 복사된 횟수를 return

//풀이
//Map에 배열번호 : 현재 원소의 개수를 저장