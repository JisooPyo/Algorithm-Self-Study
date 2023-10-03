package leetcode.al10;

import java.util.Arrays;

public class LeetArray14 {
	public static void main(String[] args) {
		LeetArray14 la14 = new LeetArray14();

		int[] nums1 = {3, 2, 2, 3};
		int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};

		System.out.println(la14.removeElement(nums1, 3));
		System.out.println(Arrays.toString(nums1));
		System.out.println(la14.removeElement(nums2, 2));
		System.out.println(Arrays.toString(nums2));
	}

	public int removeElement(int[] nums, int val) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[index] = nums[i];
				index++;
			}
		}
		return index;
	}
}
