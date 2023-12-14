package leetcode.explore.hashTable;

import java.util.HashMap;
import java.util.Map;

public class HashTable18 {
    public static void main(String[] args) {
        HashTable18 h = new HashTable18();
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        System.out.println(h.fourSumCount(nums1, nums2, nums3, nums4));
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 합, 갯수
        Map<Integer, Integer> nums12 = new HashMap<>();
        Map<Integer, Integer> nums34 = new HashMap<>();

        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum12 = nums1[i] + nums2[j];
                int sum34 = nums3[i] + nums4[j];
                nums12.put(sum12, nums12.getOrDefault(sum12, 0) + 1);
                nums34.put(sum34, nums34.getOrDefault(sum34, 0) + 1);
            }
        }

        int answer = 0;
        for (Integer i : nums12.keySet()) {
            if (nums34.containsKey(-i)) {
                answer += nums12.get(i) * nums34.get(-i);
            }
        }

        return answer;
    }

    // 나랑 비슷하지만 조금 더 짧고 간결한 풀이
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : nums3) {
            for (int l : nums4) {
                map.put(k + l, map.getOrDefault(k + l, 0) + 1);
            }
        }
        int count = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                count += map.getOrDefault(-(i + j), 0);
            }
        }
        return count;
    }
}
