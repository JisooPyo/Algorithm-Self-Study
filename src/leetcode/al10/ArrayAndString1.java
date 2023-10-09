package leetcode.al10;

public class ArrayAndString1 {
	public static void main(String[] args) {
		ArrayAndString1 aas1 = new ArrayAndString1();

		int[] nums1 = {1, 7, 3, 6, 5, 6};
		int[] nums2 = {1, 2, 3};
		int[] nums3 = {2, 1, -1};
		System.out.println(aas1.pivotIndex(nums1));
		System.out.println(aas1.pivotIndex(nums2));
		System.out.println(aas1.pivotIndex(nums3));
	}

	public int pivotIndex(int[] nums) {
		int leftSum = 0;
		int rightSum = 0;

		for (int i = 0; i < nums.length; i++) {
			rightSum += nums[i];
		}

		rightSum -= nums[0];
		if (rightSum == 0) return 0;

		int index = -1;
		for (int i = 1; i < nums.length; i++) {
			leftSum += nums[i - 1];
			rightSum -= nums[i];
			if (leftSum == rightSum) {
				index = i;
				break;
			}
		}
		return index;
	}
}
