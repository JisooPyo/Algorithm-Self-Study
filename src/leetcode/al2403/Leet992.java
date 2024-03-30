package leetcode.al2403;

import java.util.HashMap;
import java.util.Map;

public class Leet992 {
    public static void main(String[] args) {
        Leet992 l = new Leet992();

        int[] nums1 = {1, 2, 1, 2, 3};
        int[] nums2 = {1, 2, 1, 3, 4};

        System.out.println(l.subarraysWithKDistinct(nums1, 2));
        System.out.println(l.subarraysWithKDistinct(nums2, 3));
    }

    // k개 이상 - k+!개 이상 = 정확히 k개
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> map1 = new HashMap<>();
        int left1 = 0;
        int atLeastk = 0;
        for (int right1 = 0; right1 < nums.length; right1++) {
            map1.put(nums[right1], map1.getOrDefault(nums[right1], 0) + 1);
            while (map1.keySet().size() >= k) {
                atLeastk += nums.length - right1;
                if (map1.get(nums[left1]) == 1) {
                    map1.remove(nums[left1]);
                } else {
                    map1.put(nums[left1], map1.get(nums[left1]) - 1);
                }
                left1++;
            }
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        int left2 = 0;
        int atLeastkPlus1 = 0;
        for (int right2 = 0; right2 < nums.length; right2++) {
            map2.put(nums[right2], map2.getOrDefault(nums[right2], 0) + 1);
            while (map2.keySet().size() >= k + 1) {
                atLeastkPlus1 += nums.length - right2;
                if (map2.get(nums[left2]) == 1) {
                    map2.remove(nums[left2]);
                } else {
                    map2.put(nums[left2], map2.get(nums[left2]) - 1);
                }
                left2++;
            }
        }

        return atLeastk - atLeastkPlus1;
    }

    // 다른 사람의 풀이
    // Map이 아닌 배열에 수 저장
    // k개 이상 구하는 것 k+1개 이상 구하는 것 메서드화 하여 코드 줄 수를 줄임
}
