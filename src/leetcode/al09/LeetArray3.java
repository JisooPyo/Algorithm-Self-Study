package leetcode.al09;

import java.util.Arrays;

public class LeetArray3 {
	public static void main(String[] args) {
		LeetArray3 leet = new LeetArray3();
		int[] nums1 = {-4, -1, 0, 3, 10};
		int[] nums2 = {-7, -3, 2, 3, 11};
		System.out.println(Arrays.toString(leet.sortedSquares(nums1)));
		System.out.println(Arrays.toString(leet.sortedSquares(nums2)));
	}

	public int[] sortedSquares(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * nums[i];
		}
		Arrays.sort(nums);
		return nums;
	}
}
