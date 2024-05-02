package leetcode.al2405;

import java.util.HashMap;
import java.util.Map;

/**
 * 2441. Largest Positive Integer That Exists With Its Negative
 *
 * Given
 * nums: 0이 아닌 정수 배열
 *
 * -k가 array에 존재하는 가장 큰 양의 정수를 찾아라.
 */
public class Leet2441 {
    public static void main(String[] args) {
        Leet2441 l = new Leet2441();

        int[] nums1 = {-1, 2, -3, 3};
        int[] nums2 = {-1, 10, 6, 7, -7, 1};
        int[] nums3 = {-10, 8, 6, 7, -2, -3};

        System.out.println(l.findMaxK(nums1));
        System.out.println(l.findMaxK(nums2));
        System.out.println(l.findMaxK(nums3));
        System.out.println(true ^ false);
        System.out.println(false ^ true);
        System.out.println(true ^ true);
        System.out.println(false ^ false);
    }

    // 내 풀이
    public int findMaxK(int[] nums) {
        // true: +, false: -
        Map<Integer, Boolean> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (map.get(abs) == null) {
                map.put(abs, nums[i] > 0);
            } else if (map.get(abs) ^ (nums[i] > 0)) {
                max = Math.max(abs, max);
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }

    // 다른 사람의 풀이
    // * -1000 <= nums[i] <= 1000 이므로 Map 대신 1001 크기의 배열에 저장하면 조금 더 속도가 빨랐다.
    // * for문이 끝나고 System.gc() 코드를 넣은 코드가 더 공간을 적게 썼다.
}
