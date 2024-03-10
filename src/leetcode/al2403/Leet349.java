package leetcode.al2403;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Leet349 {
    public static void main(String[] args) {
        Leet349 l = new Leet349();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(l.intersection(nums1, nums2)));
        System.out.println(Arrays.toString(l.intersection(nums3, nums4)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        Set<Integer> intersection = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                intersection.add(nums2[i]);
            }
        }

        Iterator<Integer> iterator = intersection.iterator();
        int[] answer = new int[intersection.size()];
        int index = 0;
        while (iterator.hasNext()) {
            answer[index++] = iterator.next();
        }

        return answer;
    }
}
