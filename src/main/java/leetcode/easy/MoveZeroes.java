package leetcode.easy;

public class MoveZeroes {
    //Solution1
    public void moveZeroes1(int[] nums) {
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==0){
                for(int j=i+1; j<nums.length; j++){
                    if(nums[j]!=0){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }

//수도코드
//배열을 순환
//현재값이 0일 경우 for문을 통해 0이 아닌 값이 나오면 해당 위치와 바꾼다.


    //Solution2
    //---------------------------
    public void moveZeroes2(int[] nums) {
        int s = 0, f = 0;
        while (f < nums.length) {
            if (nums[f] == 0) {
                f++;
                continue;
            }
            int temp = nums[s];
            nums[s] = nums[f];
            nums[f] = temp;
            s++;
            f++;
        }
    }

}
