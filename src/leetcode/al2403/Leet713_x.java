package leetcode.al2403;

public class Leet713_x {
    public static void main(String[] args) {
        Leet713_x l = new Leet713_x();

        System.out.println(l.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(l.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }

    // 다른 사람의 풀이 - sliding window
    // 시간 복잡도: O(N)
    // right의 기준에서 개수 세기
    // [[10], 5, 2, 6] : 1개
    // [[10, 5], 2, 6] : 2개
    // [10, [5, 2], 6] : 2개
    // [10, [5, 2, 6]] : 3개
    // => 8개
    public int numSubarrayProductLessThanKOther(int[] nums, int k) {
        int sum = 1;
        int result = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum *= nums[right];
            while (sum >= k && left <= right) {
                sum /= nums[left];
                left++;
            }
            result += right - left + 1;
        }
        return result;
    }

    // 내 풀이
    // 시간 복잡도: O(N^2)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                int product = nums[i];
                count++;
                for (int j = i + 1; j < nums.length; j++) {
                    if (product * nums[j] < k) {
                        product *= nums[j];
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }

}
