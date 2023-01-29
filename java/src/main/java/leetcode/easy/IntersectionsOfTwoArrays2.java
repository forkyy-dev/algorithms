package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionsOfTwoArrays2 {
    //Solution1
    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return helper(nums2, nums1);
        }
        return helper(nums1, nums2);
    }

    private int[] helper(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                    nums2[j] = -1;
                    break;
                }
            }
        }

        int[] result = new int[list.size()];
        int size = 0;
        for (int num : list) {
            result[size++] = num;
        }
        return result;
    }

    //Solution2
    //----------------------------------------------------
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        if (nums1.length < nums2.length) {
            int[] temp = Arrays.copyOf(nums1, nums1.length);
            nums1 = Arrays.copyOf(nums2, nums2.length);
            nums2 = temp;
        }

        int[] result = new int[nums1.length];

        int point1 = 0;
        int point2 = 0;
        int index = 0;

        while (point1 < nums1.length && point2 < nums2.length) {
            if (nums1[point1] < nums2[point2]) {
                point1++;
            } else if (nums1[point1] > nums2[point2]) {
                point2++;
            } else if (nums1[point1] == nums2[point2]) {
                result[index++] = nums1[point1++];
                point2++;
            }
        }
        return Arrays.copyOf(result, index);


    }
//수도코드
//정렬시킨다.
//[1,1,2,2] / [2,2]
//2개의 포인트를 만든다.
//작은쪽 포인트를 1 더한다.
// 같을경우 해당 값을 저장하고 양쪽 포인트를 올린다.
}
