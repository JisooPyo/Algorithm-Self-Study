package leetcode.al2403;

import java.util.HashMap;
import java.util.Map;

public class Leet525_x {
    public static void main(String[] args) {
        Leet525_x l = new Leet525_x();
        int[] nums1 = {0, 1};
        int[] nums2 = {0, 1, 0};
        int[] nums3 = {0, 1, 0, 1};
        int[] nums4 = {1, 1, 1, 0, 1, 1, 0, 1, 0, 1};   // 6
        // System.out.println(l.findMaxLength(nums1));     // 2
        // System.out.println(l.findMaxLength(nums2));     // 2
        // System.out.println(l.findMaxLength(nums3));     // 4
        System.out.println(l.findMaxLength(nums4));     // 6
    }

    // prefix sum 문제인건 알겠는데 어떻게 풀어야 할지를 모르겠다 ;ㅅ;
    // 다른 사람 풀이
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        int subArrayLength = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sum == 0) {
                subArrayLength = i + 1;
            } else if (mp.containsKey(sum)) {
                subArrayLength = Math.max(subArrayLength, i - mp.get(sum));
            } else {
                mp.put(sum, i);
            }
        }
        return subArrayLength;
    }
}
