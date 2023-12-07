package leetcode.al12;

import java.util.HashSet;

public class HashTable3 {
    public static void main(String[] args) {
        HashTable3 h = new HashTable3();

        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println(h.containsDuplicate(nums1));
        System.out.println(h.containsDuplicate(nums2));
        System.out.println(h.containsDuplicate(nums3));
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
