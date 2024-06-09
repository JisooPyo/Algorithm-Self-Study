package leetcode.al2406;

import java.util.HashMap;
import java.util.Map;

/**
 * Medium
 * 974. Subarray Sums Divisible by K
 *
 * Given
 * nums : 정수 배열
 * k : 정수
 *
 * Return
 * 합계가 k로 나누어지는 non-empty subarray 의 수를 구하라.
 */
public class Leet974 {
    public static void main(String[] args) {
        Leet974 l = new Leet974();

        int[] nums1 = {4, 5, 0, -2, -3, 1};
        int[] nums2 = {5};
        int[] nums3 = {-1, 2, 9};
        int[] nums4 = {2, -2, 2, -4};
        int[] nums5 = {8, 9, 7, 8, 9};

        System.out.println(l.subarraysDivByK(nums1, 5));    // 7
        System.out.println(l.subarraysDivByK(nums2, 9));    // 0
        System.out.println(l.subarraysDivByK(nums3, 2));    // 2
        System.out.println(l.subarraysDivByK(nums4, 6));    // 2
        System.out.println(l.subarraysDivByK(nums5, 8));    // 7
    }

    // 내 풀이 : 17ms
    // 푸는 데 걸린 시간 : 21m
    // 어제 풀었던 문제와 비슷해서 수월하게 풀었다.
    // 다른 사람의 풀이 중 더 빨랐던 풀이는 배열을 이용해서 푼 것.
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (remainder < 0) {
                remainder += k;
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        int res = 0;
        for (Integer remainder : map.keySet()) {
            int count = map.get(remainder);
            if (remainder == 0) {
                res += count * (count + 1) / 2;
            } else if (count > 1) {
                res += count * (count - 1) / 2;
            }
        }
        return res;
    }
}
