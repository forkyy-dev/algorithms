package leetcode.easy;

public class MaximumSubArray {
    //Solution 1
    public int maxSubArray1(int[] nums) {
        int result = nums[0];
        int sum = nums[0];

        for(int i=1; i<nums.length; i++){
            if(sum + nums[i] > nums[i]){
                sum = sum + nums[i];
            }else{
                sum = nums[i];
            }
            if(sum > result){
                result = sum;
            }
        }
        return result;
    }
    //수도코드
//현재 합과 결과값 변수를 생성한다.
//현재합과 현재값을 더한 값과 현재값을 비교해서 둘 중 더 큰 값을 넣는다.
//result도 마찬가지
    //Solution2
    public int maxSubArray2(int[] nums) {
        int current = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }
}
