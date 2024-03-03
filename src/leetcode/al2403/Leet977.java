package leetcode.al2403;

import java.util.Arrays;

public class Leet977 {
    public static void main(String[] args) {
        Leet977 l = new Leet977();
        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] nums2 = {-7, -3, 2, 3, 11};
        int[] nums3 = {1, 2, 3, 4, 5};
        int[] nums4 = {-9, -9, -7, -5, -3, -1};
        System.out.println(Arrays.toString(l.sortedSquares(nums1)));
        System.out.println(Arrays.toString(l.sortedSquares(nums2)));
        System.out.println(Arrays.toString(l.sortedSquares(nums3)));
        System.out.println(Arrays.toString(l.sortedSquares(nums4)));
    }

    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        int absolute = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) <= Math.abs(absolute)) {
                absolute = Math.abs(nums[i]);
                left = i;
            } else {
                break;
            }
        }
        right = left;

        if (left == 0) {
            right++;
        } else {
            left--;
        }
        int index = 0;
        while (index < answer.length) {
            if (left == -1) {
                answer[index] = nums[right] * nums[right];
                right++;
                index++;
                continue;
            }
            if (right == answer.length) {
                answer[index] = nums[left] * nums[left];
                left--;
                index++;
                continue;
            }
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                answer[index] = nums[right] * nums[right];
                right++;
            } else {
                answer[index] = nums[left] * nums[left];
                left--;
            }
            index++;
        }

        return answer;
    }
}
