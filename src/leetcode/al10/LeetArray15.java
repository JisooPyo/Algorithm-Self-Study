package leetcode.al10;

import java.util.Arrays;

public class LeetArray15 {
	public static void main(String[] args) {
		LeetArray15 la15 = new LeetArray15();

		int[] heights1 = {1, 1, 4, 2, 1, 3};
		int[] heights2 = {5, 1, 2, 3, 4};
		int[] heights3 = {1, 2, 3, 4, 5};

		System.out.println(la15.heightChecker(heights1));
		System.out.println(la15.heightChecker(heights2));
		System.out.println(la15.heightChecker(heights3));
	}

	public int heightChecker(int[] heights) {
		int[] sort = Arrays.copyOf(heights, heights.length);
		Arrays.sort(sort);
		int count = 0;
		for (int i = 0; i < heights.length; i++) {
			if (sort[i] != heights[i]) count++;
		}
		return count;
	}
}
