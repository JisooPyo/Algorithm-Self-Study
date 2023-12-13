package leetcode.explore.hashTable;

import java.util.HashSet;

public class HashTable4 {
    public static void main(String[] args) {
        HashTable4 h = new HashTable4();

        int[] nums1 = {2, 2, 1};
        int[] nums2 = {4, 1, 2, 1, 2};
        int[] nums3 = {1};

        System.out.println(h.singleNumber(nums1));  // 1
        System.out.println(h.singleNumber(nums2));  // 4
        System.out.println(h.singleNumber(nums3));  // 1
    }

    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
                continue;
            }
            set.add(nums[i]);
        }
        int answer = 0;
        for (Integer i : set) {
            answer = i;
        }
        return answer;
    }
}
