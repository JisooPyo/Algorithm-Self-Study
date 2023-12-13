package leetcode.explore.arrayAndString;

import java.util.Arrays;

public class ArrayAndString12 {
    public static void main(String[] args) {
        ArrayAndString12 aas12 = new ArrayAndString12();

        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {2, 3, 4};
        int[] nums3 = {-1, 0};

        System.out.println(Arrays.toString(aas12.twoSum(nums1, 9)));
        System.out.println(Arrays.toString(aas12.twoSum(nums2, 6)));
        System.out.println(Arrays.toString(aas12.twoSum(nums3, -1)));

    }

    // 시간복잡도 : o(n^2)
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];

        loop1:
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    answer[0] = i + 1;
                    answer[1] = j + 1;
                    break loop1;
                }
            }
        }

        return answer;
    }

    /**
     * 다른 사람의 풀이
     * <p>
     * 시간복잡도 : o(n)
     * index 0 -> left, index 마지막 -> right로 잡고
     * sum이 크면 right를 줄이고, sum이 작으면 left를 올리는 식으로
     * 답을 구할 수 있다.
     * 이미 정렬이 되어 있다는 점, 반드시 답은 한 쌍이 나온다는 점에서 쓸 수 있는 방법.
     */
    public int[] twoSum1(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (nums[l] + nums[r] != target) {
            if (nums[l] + nums[r] < target) l++;
            else r--;
        }

        return new int[]{l + 1, r + 1};
    }
}
