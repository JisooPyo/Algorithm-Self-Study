package leetcode.al2404;

import java.util.List;

// Bit
public class Leet2859 {
    public static void main(String[] args) {
        Leet2859 l = new Leet2859();

        List<Integer> nums1 = List.of(5, 10, 1, 5, 2);
        List<Integer> nums2 = List.of(4, 3, 2, 1);

        System.out.println(l.sumIndicesWithKSetBits(nums1, 1));
        System.out.println(l.sumIndicesWithKSetBits(nums2, 2));
    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k) {
                sum += nums.get(i);
            }
        }
        return sum;
    }
}
