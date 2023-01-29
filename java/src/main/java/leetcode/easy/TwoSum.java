package leetcode.easy;

public class TwoSum {

    public int[] twoSum1(int[] nums, int target) {
        int answer1 = 0;
        int answer2 = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer1 = i;
                    answer2 = j;
                    break;
                }
            }
            if (answer1 != 0 && answer2 != 0) {
                break;
            }
        }
        return new int[]{answer1,answer2};
    }

    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }

        }
        return null;
    }
}
