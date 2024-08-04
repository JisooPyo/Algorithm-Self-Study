package leetcode.al2408;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Medium
 * 1508. Range Sum of Sorted Subarray Sums
 *
 * n개의 양의 정수로 이루어진 배열 nums 가 주어집니다.
 * nums 배열의 모든 subarray들의 합을 계산한 후, n * (n + 1) / 2개의 합이 나오면
 * 그 합으로 새로운 배열을 만들어 오름차순으로 정렬합니다.
 *
 * 새로운 배열에서 index left 부터 index right 까지의 숫자들의 합을 반환하세요.(1-indexed)
 * 답변이 너무 크다면 modulo 10^9+7 을 return 하세요.
 */
public class Leet1508 {
    public static void main(String[] args) {
        Leet1508 leet1508 = new Leet1508();
        int[] nums = {1, 2, 3, 4};
        System.out.println(leet1508.rangeSum(nums, 4, 1, 5));   // 13
        System.out.println(leet1508.rangeSum(nums, 4, 3, 4));   // 6
        System.out.println(leet1508.rangeSum(nums, 4, 1, 10));  // 50
    }

    // 내 풀이: 155ms
    // 걸린 시간: 18m
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int subSum = sum;
            list.add(subSum);
            for (int j = 0; j <= nums.length - (i + 2); j++) {
                subSum -= nums[j];
                subSum += nums[j + i + 1];
                list.add(subSum);
            }
        }
        list.sort((a, b) -> a - b);
        long res = 0;
        for (int i = left - 1; i < right; i++) {
            res += list.get(i);
        }
        long mod = (long)Math.pow(10, 9) + 7;
        return (int)(res % mod);
    }

    //  다른 사람의 풀이 : 1ms
    // sliding window, two pointer
    long largestSubArraySumPossible = 0;    // 가능한 가장 큰 부분 배열의 합
    long smallestSubArraySumPossible = 0;   // 가능한 가장 작은 부분 배열의 합

    public int rangeSumOther(int[] nums, int n, int left, int right) {
        int mod = (int)1e9 + 7;
        long ans = 0;
        smallestSubArraySumPossible = nums[0];

        for (int i = 0; i < n; i++) {
            largestSubArraySumPossible += nums[i];
            smallestSubArraySumPossible = Math.min(smallestSubArraySumPossible, nums[i]);
        }

        ans = firstKSubarraysSum(nums, right) % mod;
        ans -= firstKSubarraysSum(nums, left - 1) % mod;

        return (int)(ans % mod);
    }

    public long firstKSubarraysSum(int[] nums, int k) {
        long start = smallestSubArraySumPossible, end = largestSubArraySumPossible;
        while (start < end) {
            long mid = start + (end - start) / 2;
            if (subArraysWithSumLessThanOrEqualTo(nums, mid).getKey() < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        Map.Entry<Integer, Long> map = subArraysWithSumLessThanOrEqualTo(nums, start);
        long totalOfFirstKSubarraysSum = map.getValue();
        int countOfSuchSubArrs = map.getKey();
        return totalOfFirstKSubarraysSum - start * (countOfSuchSubArrs - k);
    }

    // 특정 합 이하의 부분 배열의 개수와 합 계산
    public Map.Entry<Integer, Long> subArraysWithSumLessThanOrEqualTo(int[] nums, long target) {
        int countOfSuchSubArrays = 0;
        long totalSum = 0;
        long windowSum = 0;
        long currSum = 0;
        int n = nums.length;

        for (int left = 0, right = 0; right < n; ++right) {
            currSum += (long)nums[right] * (right - left + 1);
            windowSum += nums[right];
            while (windowSum > target) {
                currSum -= windowSum;
                windowSum -= nums[left++];
            }
            countOfSuchSubArrays += right - left + 1;
            totalSum += currSum;
        }
        return new AbstractMap.SimpleEntry<>(Integer.valueOf(countOfSuchSubArrays), Long.valueOf(totalSum));
    }
}
