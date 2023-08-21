package leetcode.al08;

import java.util.Arrays;

public class L1480 {
	public static void main(String[] args) {
		L1480 l = new L1480();
		int[] nums1 = {1, 2, 3, 4};
		int[] nums2 = {1, 1, 1, 1, 1};
		int[] nums3 = {3, 1, 2, 10, 1};
		System.out.println(Arrays.toString(l.runningSum(nums1)));
		System.out.println(Arrays.toString(l.runningSum(nums2)));
		System.out.println(Arrays.toString(l.runningSum(nums3)));
	}

	public int[] runningSum(int[] nums) {
		int[] answer = new int[nums.length];
		answer[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			answer[i] = answer[i - 1] + nums[i];
		}
		return answer;
	}

}
