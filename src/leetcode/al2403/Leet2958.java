package leetcode.al2403;

import java.util.HashMap;
import java.util.Map;

public class Leet2958 {
    public static void main(String[] args) {
        Leet2958 l = new Leet2958();

        int[] nums1 = {1, 2, 3, 1, 2, 3, 1, 2};
        int[] nums2 = {1, 2, 1, 2, 1, 2, 1, 2};
        int[] nums3 = {5, 5, 5, 5, 5, 5, 5};

        System.out.println(l.maxSubarrayLength(nums1, 2));
        System.out.println(l.maxSubarrayLength(nums2, 1));
        System.out.println(l.maxSubarrayLength(nums3, 4));
    }

    // 내 풀이
    // 드디어 비슷한 유형의 문제를 풀었다..! ;ㅅ; 감동..
    public int maxSubarrayLength(int[] nums, int k) {
        // num, count
        Map<Integer, Integer> map = new HashMap<>();
        int length = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (map.getOrDefault(nums[right], 0) == k) {
                while (map.get(nums[right]) == k) {
                    map.put(nums[left], map.get(nums[left]) - 1);
                    left++;
                }
            }
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            length = Math.max(length, right - left + 1);
        }
        return length;
    }

    // 다른 사람의 풀이
    // Map에서 숫자의 개수를 저장하지 않고 배열의 index를 이용해서 숫자의 개수 저장
    // 공간을 더 쓰는 대신 조금 더 빨랐다.
}
