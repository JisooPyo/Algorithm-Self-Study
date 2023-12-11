package leetcode.al12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashTable5 {
    public static void main(String[] args) {
        HashTable5 h = new HashTable5();

        int[] nums1_1 = {1, 2, 2, 1};
        int[] nums2_1 = {2, 2};

        int[] nums1_2 = {4, 9, 5};
        int[] nums2_2 = {9, 4, 9, 8, 4};

        // [2]
        System.out.println(Arrays.toString(h.intersection(nums1_1, nums2_1)));
        // [9, 4]
        System.out.println(Arrays.toString(h.intersection(nums1_2, nums2_2)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (Integer i : nums1) {
            set1.add(i);
        }
        for (Integer i : nums2) {
            set2.add(i);
        }
        set1.retainAll(set2);

        int[] answer = new int[set1.size()];
        int index = 0;
        for (Integer i : set1) {
            answer[index++] = i;
        }
        
        return answer;
    }
}
