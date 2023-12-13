package leetcode.explore.arrayAndString;

public class ArrayAndString2 {
    public static void main(String[] args) {
        ArrayAndString2 aas2 = new ArrayAndString2();

        int[] nums1 = {3, 6, 1, 0};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 0};

        System.out.println(aas2.dominantIndex(nums1));
        System.out.println(aas2.dominantIndex(nums2));
        System.out.println(aas2.dominantIndex(nums3));
    }

    public int dominantIndex(int[] nums) {
        int firstIndex, secondIndex;

        if (nums[0] < nums[1]) {
            firstIndex = 1;
            secondIndex = 0;
        } else {
            firstIndex = 0;
            secondIndex = 1;
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[firstIndex] < nums[i]) {
                secondIndex = firstIndex;
                firstIndex = i;
            } else if (nums[secondIndex] < nums[i]) {
                secondIndex = i;
            }
        }

        return nums[firstIndex] >= nums[secondIndex] * 2 ? firstIndex : -1;
    }
}
