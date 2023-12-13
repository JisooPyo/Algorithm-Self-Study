package leetcode.explore.array;

public class LeetArray2 {
    public static void main(String[] args) {
        LeetArray2 leet = new LeetArray2();
        int[] nums1 = {12, 345, 2, 6, 7896};
        int[] nums2 = {555, 901, 482, 1771};
        System.out.println(leet.findNumbers(nums1));
        System.out.println(leet.findNumbers(nums2));
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (numOfDigits(nums[i]) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // 자릿수를 구하는 메서드
    private int numOfDigits(int number) {
        int num = 0;
        while (number != 0) {
            num++;
            number = number / 10;
        }
        return num;
    }
}
