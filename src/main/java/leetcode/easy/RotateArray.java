package leetcode.easy;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverseArr(nums, 0, nums.length - 1);
        reverseArr(nums, 0, k - 1);
        reverseArr(nums, k, nums.length - 1);

    }

    private void reverseArr(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

// 수도코드
//1. 뒤에서 k번째 수까지 그대로 앞으로 이동하면 된다.
//2. 기존 배열 내에서 수를 옮기는 방법은..?
//2-1. 맨 끝의 수를 앞으로 당기고 나머지를 미룬다. -> 시간 초과.
// while(k>0){
//             int lastNum = nums[nums.length-1];
//             for(int i=nums.length-1; i>0; i--){
//                 nums[i] = nums[i-1];
//             }
//             nums[0] = lastNum;
//             k--;
//         }

//2-2. 배열을 뒤집는다.
//2-2-1. 앞에서부터 k-1번째 데이터까지 뒤집는다.
//2-2-2. k번째부터 마지막 데이터까지 뒤집는다.
}
