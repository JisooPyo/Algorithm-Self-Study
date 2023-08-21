package leetcode.al08;

import java.util.Arrays;

public class L1 {
	public static void main(String[] args) {
		L1 t = new L1();
		int[] nums1 = {2, 7, 11, 15};
		int target1 = 9;
		// [0, 1]
		int[] nums2 = {3, 2, 4};
		int target2 = 6;
		// [1, 2]
		int[] nums3 = {3, 3};
		int target3 = 6;
		// [0, 1]

		System.out.println(Arrays.toString(t.twoSum(nums1, target1)));
		System.out.println(Arrays.toString(t.twoSum(nums2, target2)));
		System.out.println(Arrays.toString(t.twoSum(nums3, target3)));
	}

	public int[] twoSum(int[] nums, int target) {
		int[] answer = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					answer[0] = i;
					answer[1] = j;
					break;
				}
			}
		}
		return answer;
	}
}
