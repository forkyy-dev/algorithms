package leetcode.easy;

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        nums[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            nums[i] = Math.max(nums[i-1], nums[i-2]+nums[i]);
        }
        return nums[nums.length-1];
    }
}
//수도코드
//2부터 시작해서 이전까지 훔친 돈과 전전값+현재값을 비교해가며 더 큰 값을 저장한다.