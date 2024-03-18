package leetcode.al2403;

import java.util.Arrays;

public class Leet2574 {
    public static void main(String[] args) {
        Leet2574 l = new Leet2574();
        int[] nums1 = {10, 4, 8, 3};
        int[] nums2 = {1};
        // [15, 1, 11, 22]
        System.out.println(Arrays.toString(l.leftRightDifference(nums1)));
        // [0]
        System.out.println(Arrays.toString(l.leftRightDifference(nums2)));
    }

    public int[] leftRightDifference(int[] nums) {
        // left sum
        int[] answer = new int[nums.length];
        answer[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] + nums[i - 1];
        }

        // right sum
        int[] rightSum = new int[nums.length];
        rightSum[rightSum.length - 1] = 0;
        for (int i = rightSum.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }

        // |left - right|
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Math.abs(answer[i] - rightSum[i]);
        }

        return answer;
    }
}
