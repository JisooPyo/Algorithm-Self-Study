package leetcode.explore.array;

import java.util.Arrays;

public class LeetArray12 {
    public static void main(String[] args) {
        LeetArray12 la12 = new LeetArray12();

        int[] nums1 = {0, 1, 0, 3, 12};
        int[] nums2 = {0};

        la12.moveZeroes(nums1);
        la12.moveZeroes(nums2);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
