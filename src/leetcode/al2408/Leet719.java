package leetcode.al2408;

import java.util.Arrays;

/**
 * Hard
 * 719. Find K-th Smallest Pair Distance
 *
 * 정수 a,b의 "distance of a pair"은 a와 b사이의 절대거리로 정의된다.
 *
 * 정수 배열 nums와 정수 k가 주어질 때,
 * 0 <= i < j < nums.length 에서 nums[i]와 nums[j] 쌍의 k번째 가장 작은 거리를 구하시오.
 */
public class Leet719 {
    public static void main(String[] args) {
        Leet719 leet719 = new Leet719();

        int[] nums1 = {1, 3, 1};
        int[] nums2 = {1, 1, 1};
        int[] nums3 = {1, 6, 1};
        int[] nums4 = {1, 2, 0, 2, 1, 0, 1, 1, 0, 2, 2, 0, 2, 0, 1, 1, 1, 0, 1, 0, 1, 1, 2, 2, 2, 2, 0, 0, 2, 1, 2, 1,
            2, 0, 0, 0, 1, 0, 0, 1, 0, 2, 1, 1, 1, 1, 0, 2, 2, 1, 0, 2, 0, 2, 2, 2, 1, 0, 2, 2, 2, 2, 0, 0, 1, 0, 1, 1,
            2, 1, 2, 2, 1, 1, 0, 2, 0, 1, 0, 1, 1, 2, 0, 1, 1, 1, 1, 2, 0, 2, 2, 0, 0, 1, 1, 1, 1, 2, 1, 2, 2, 1, 2, 0,
            1, 2, 2, 1, 1, 2, 1, 0, 1, 1, 1, 0, 0, 1, 2, 0, 2, 1, 0, 1, 2, 0, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0, 1};

        System.out.println(leet719.smallestDistancePair(nums1, 1));     // 0
        System.out.println(leet719.smallestDistancePair(nums2, 2));     // 0
        System.out.println(leet719.smallestDistancePair(nums3, 3));     // 5
        System.out.println(leet719.smallestDistancePair(nums4, 6));
    }

    // 내 풀이: 368ms
    // 시간 복잡도: O(N^2)
    public int smallestDistancePair(int[] nums, int k) {
        int[] distanceRecord = new int[1_000_001];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                distanceRecord[Math.abs(nums[i] - nums[j])]++;
            }
        }
        for (int i = 0; i < 1_000_001; i++) {
            if (distanceRecord[i] < k) {
                k -= distanceRecord[i];
                continue;
            }
            return i;
        }
        return 0;
    }

    // 다른 사람 풀이
    // 이진 탐색
    // 시간 복잡도: O(N log N)
    public int smallestDistancePairOther(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countPairsWithSumMid(nums, mid);
            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    int countPairsWithSumMid(int[] nums, int sum) {
        int count = 0;
        int left = 0;

        for (int right = 1; right < nums.length; right++) {
            while (nums[right] - nums[left] > sum) {
                left++;
            }
            count += right - left;
        }
        return count;

    }
}
