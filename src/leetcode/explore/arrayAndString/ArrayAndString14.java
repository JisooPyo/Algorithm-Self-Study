// Rotate Array
package leetcode.explore.arrayAndString;

import java.util.Arrays;

public class ArrayAndString14 {
    public static void main(String[] args) {
        ArrayAndString14 aas14 = new ArrayAndString14();

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {-1, -100, 3, 99};

//		aas14.rotate(nums1, 3);
//		aas14.rotate(nums2, 2);
//
//		System.out.println(Arrays.toString(nums1));
//		System.out.println(Arrays.toString(nums2));

        aas14.rotate3(nums1, 3);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * Follow up:
     * Try to come up with as many solutions as you can.
     * There are at least three different ways to solve this problem.
     * Could you do it in-place with O(1) extra space?
     */

    // 첫번째 구현. 공간복잡도 != O(1) -> 통과
    public void rotate(int[] nums, int k) {
        int[] nums2 = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            nums2[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums2[i];
        }
    }

    // 두번째 구현. 공간 복잡도가 1이지만 시간 측면에서 통과 X
    public void rotate2(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        for (int i = 0; i < k; i++) {
            oneRotate(nums);
        }
    }

    private void oneRotate(int[] nums) {
        int temp = nums[0];
        nums[0] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 1; i--) {
            nums[i + 1] = nums[i];
        }
        nums[1] = temp;
    }

    // 세 번째 구현 실패 -> 다른 사람의 풀이 확인

    /**
     * we have to first reverse the whole array by swapping first element with the last one and so on..
     * you will get[7,6,5,4,3,2,1]
     * <p>
     * reverse the elements from 0 to k-1
     * reverse the elements 7,6,5
     * you will get [5,6,7,4,3,2,1]
     * <p>
     * reverse the elements from k to n-1
     * reverse the elements 4,3,2,1
     * you will get[5,6,7,1,2,3,4]
     */
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
