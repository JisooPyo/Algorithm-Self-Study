package leetcode.al09;

import java.util.Arrays;

public class LeetArray7 {
	public static void main(String[] args) {
		LeetArray7 la = new LeetArray7();
		int[] nums1 = {1, 1, 2};
		int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		System.out.println(la.removeDuplicates(nums1));
		System.out.println(la.removeDuplicates(nums2));
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));
	}

	public int removeDuplicates(int[] nums) {
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[index] != nums[i]) {
				index++;
				nums[index] = nums[i];
			}
		}
		return index + 1;
	}
}
