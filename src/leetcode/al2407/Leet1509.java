package leetcode.al2407;

import java.util.Arrays;

/**
 Medium
 1509. Minimum Difference Between Largest and Smallest Value in Three Moves

 정수 배열 nums가 주어집니다.

 한 번의 이동에서, nums의 요소 중 하나를 선택하여 임의의 값으로 변경할 수 있습니다.

 최대 세 번의 이동을 수행한 후 nums의 가장 큰 값과 가장 작은 값의 차이의 최솟값을 반환하세요.
 */
public class Leet1509 {
    public static void main(String[] args) {
        Leet1509 l = new Leet1509();

        int[] nums1 = {5, 3, 2, 4};
        int[] nums2 = {1, 5, 0, 10, 14};
        int[] nums3 = {3, 100, 20};

        System.out.println(l.minDifference(nums1));     // 0
        System.out.println(l.minDifference(nums2));     // 1
        System.out.println(l.minDifference(nums3));     // 0
    }

    // 내 풀이 : 15ms
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int diff = nums.length - 4;
        for (int i = 0; i < nums.length - diff; i++) {
            min = Math.min(nums[i + diff] - nums[i], min);
        }
        return min;
    }
}
