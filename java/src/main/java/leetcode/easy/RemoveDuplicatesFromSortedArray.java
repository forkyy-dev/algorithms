package leetcode.easy;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int point = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[point] != nums[i]){
                point+=1;
                nums[point] = nums[i];
            }
        }
        return point+1;
    }


//수도코드
//1. point라는 숫자 변수 하나를 만든다.
//2. for문을 통해 배열을 순환한다.
//3. nums[i]의 값이 nums[point]와 동일하지 않으면 point+1 위치에 해당 값을 저장한다.
}
