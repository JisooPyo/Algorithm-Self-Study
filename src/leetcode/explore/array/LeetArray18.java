package leetcode.explore.array;

import java.util.Arrays;

public class LeetArray18 {
    public static void main(String[] args) {
        LeetArray18 la18 = new LeetArray18();

        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] nums2 = {-7, -3, 2, 3, 11};

//		System.out.println(Arrays.toString(la18.sortedSquares(nums1)));
//		System.out.println(Arrays.toString(la18.sortedSquares(nums2)));

        System.out.println(Arrays.toString(la18.otherSolutionSortedSquares(nums1)));
        System.out.println(Arrays.toString(la18.otherSolutionSortedSquares(nums2)));
    }

    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    // Follow up: Squaring each element and sorting the new array is very trivial,
    // could you find an O(n) solution using a different approach?

    // other: two pointer solution
    // 내가 간과하고 있던 것: 주어진 array는 오름차순으로 정렬되어 있다.
    // 안쪽으로 가면 갈수록 절대값이 작아지니 음수를 가리킬 것으로 예상되는 negative pointer
    // 양수를 가리킬 것으로 예상되는 positive pointer를 두어
    // 절대값을 비교해가며 끝부터 넣는 것.
    public int[] otherSolutionSortedSquares(int[] nums) {
        int[] squares = new int[nums.length];
        int np = 0;
        int pp = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[pp] >= Math.abs(nums[np])) {
                squares[i] =
                        nums[pp] * nums[pp--];

            } else if (nums[pp] < Math.abs(nums[np])) {
                squares[i] =
                        nums[np] * nums[np++];

            } else {
                squares[i++] =
                        nums[pp] * nums[pp--];
                squares[i] =
                        nums[np] * nums[np++];
            }
        }
        return squares;
    }

}
