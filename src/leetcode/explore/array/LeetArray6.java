package leetcode.explore.array;

public class LeetArray6 {
    public static void main(String[] args) {
        LeetArray6 la = new LeetArray6();
        int[] nums1 = {3, 2, 2, 3};
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(la.removeElement(nums1, 3));
        System.out.println(la.removeElement(nums2, 2));
    }

    public int removeElement(int[] nums, int val) {
        int count = nums.length;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count--;
            } else {
                nums[index] = nums[i];
                index++;
            }
        }
        return count;
    }
}
