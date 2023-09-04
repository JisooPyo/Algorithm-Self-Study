package leetcode.al09;

import java.util.Arrays;

public class LeetArray4 {
	public static void main(String[] args) {
		LeetArray4 la = new LeetArray4();

		int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
		int[] arr2 = {1, 2, 3};
		la.duplicateZeros(arr1);
		la.duplicateZeros(arr2);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}

	public void duplicateZeros(int[] arr) {
		int[] duplicate = Arrays.copyOf(arr, arr.length);

		int arrIndex = 0;
		for (int i = 0; i < duplicate.length; i++) {
			if (arrIndex == duplicate.length) {
				break;
			}
			arr[arrIndex] = duplicate[i];
			if (duplicate[i] == 0) {
				arrIndex++;
				if (arrIndex == duplicate.length) {
					break;
				}
				arr[arrIndex] = duplicate[i];
			}
			arrIndex++;
		}
	}
}
