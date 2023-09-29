package leetcode.al09;

public class LeetArray11 {
	public static void main(String[] args) {
		LeetArray11 la11 = new LeetArray11();

		int[] nums1 = {1, 1, 2};
		int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

		System.out.println(la11.removeDuplicates(nums1));
		System.out.println(la11.removeDuplicates(nums2));
	}

	public int removeDuplicates(int[] nums) {
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[index]) {
				index++;
				nums[index] = nums[i];
			}
		}
		return index + 1;

	}
}
