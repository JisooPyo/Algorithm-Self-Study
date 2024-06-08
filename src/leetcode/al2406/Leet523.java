package leetcode.al2406;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Medium
 * 523. Continuous Subarray Sum
 *
 * Given
 * nums : 정수 배열
 * k : 정수
 *
 * Return
 * nums 가 good subarray 이면 true 아니면 false 를 반환하라.
 *
 * Note.
 * good subarray : 길이가 적어도 2이상이어야 한다.
 *                 subarray 의 원소들의 합이 k의 배수여야 한다.
 * subarray : 연속된 부분집합
 */
public class Leet523 {
    public static void main(String[] args) {
        Leet523 l = new Leet523();

        int[] nums1 = {23, 2, 4, 6, 7};
        int[] nums2 = {23, 2, 6, 4, 7};
        int[] nums3 = {1, 0};
        int[] nums4 = {0, 1, 0, 3, 0, 4, 0, 4, 0};
        int[] sum = {0, 1, 1, 4, 4, 3, 3, 2, 2};

        System.out.println(l.checkSubarraySum(nums1, 6));  // true
        System.out.println(l.checkSubarraySum(nums2, 6));  // true
        System.out.println(l.checkSubarraySum(nums2, 13));  // false
        System.out.println(l.checkSubarraySum(nums3, 2));  // false
        System.out.println(l.checkSubarraySum(nums4, 5));  // false
    }

    // 내 풀이(22ms) : 43m
    // 시간 복잡도 : O(n)
    // 공간 복잡도 : Map 의 크기
    // prefix Sum 의 나머지 - prefix Sum 의 나머지 = 0 이면 사이 합의 k의 배수임을 이용한다.
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 1) {
            return false;
        }

        // sum의 나머지와 index 저장
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= 1 && sum % k == 0) {
                return true;
            }
            if (map.get(sum % k) != null) {
                if (i - map.get(sum % k) >= 2) {
                    return true;
                }
                continue;
            }
            map.put(sum % k, i);
        }
        return false;
    }

    // 다른 사람의 풀이
    // 나와 같은 포인트를 이용해서 풀었지만 하나하나 다 확인하는 식으로 풀었다.
    // 시간 복잡도 : O(n^2)
    // 공간 복잡도 : O(1)
    public boolean checkSubarraySumOther(int[] nums, int k) {
        if (nums[0] == 300000) {
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0 && nums[i - 1] == 0)
                return true;
        }

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            if (nums[i] % k == 0)
                return true;
            int j = i;
            while (j > 1 && nums[i] > k) {
                if ((nums[i] - nums[j - 2]) % k == 0)
                    return true;
                j--;
            }
        }
        return false;
    }

}
