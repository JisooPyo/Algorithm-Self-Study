package leetcode.al2403;

import java.util.HashMap;
import java.util.Map;

public class Leet3005 {
    public static void main(String[] args) {
        Leet3005 l = new Leet3005();
        int[] nums1 = {1, 2, 2, 3, 1, 4};
        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println(l.maxFrequencyElements(nums1));
        System.out.println(l.maxFrequencyElements(nums2));
    }

    public int maxFrequencyElements(int[] nums) {
        // element, frequency 맵핑
        Map<Integer, Integer> map = new HashMap<>();

        // maxFrequency 구하기
        int maxFrequency = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = map.getOrDefault(nums[i], 0);
            map.put(nums[i], value + 1);
            maxFrequency = Math.max(maxFrequency, value + 1);
        }

        // maxFrequency인 원소 개수 카운팅
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == maxFrequency) {
                count++;
            }
        }

        return count;
    }
}
