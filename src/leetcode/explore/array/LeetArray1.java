package leetcode.explore.array;

public class LeetArray1 {
    public static void main(String[] args) {
        LeetArray1 l = new LeetArray1();

        int[] nums1 = {1, 1, 0, 1, 1, 1};
        int[] nums2 = {1, 0, 1, 1, 0, 1};

        System.out.println(l.findMaxConsecutiveOnes(nums1));
        System.out.println(l.findMaxConsecutiveOnes(nums2));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
