package leetcode.explore.array;

import java.util.Arrays;

public class LeetArray5 {
    public static void main(String[] args) {
        LeetArray5 la = new LeetArray5();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {1};
        int[] nums3 = {0};

        la.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        la.merge(nums2, 1, new int[]{}, 0);
        la.merge(nums3, 0, new int[]{1}, 1);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, 0, nums1, 0, m);
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

}
