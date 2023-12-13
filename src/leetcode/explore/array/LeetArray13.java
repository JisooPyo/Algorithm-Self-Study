package leetcode.explore.array;

import java.util.Arrays;

public class LeetArray13 {
    public static void main(String[] args) {
        LeetArray13 la13 = new LeetArray13();

        int[] nums1 = {3, 1, 2, 4};
        int[] nums2 = {0};

        System.out.println(Arrays.toString(la13.sortArrayByParity(nums1)));
        System.out.println(Arrays.toString(la13.sortArrayByParity(nums2)));
    }

    public int[] sortArrayByParity(int[] nums) {
        int[] answer = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                answer[index] = nums[i];
                index++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                answer[index] = nums[i];
                index++;
            }
        }
        return answer;
    }
}

/*
순서는 상관없으니까 짝수는 앞에서부터 홀수는 뒤에서부터 채워넣으면 되는 것이었다!!
 */