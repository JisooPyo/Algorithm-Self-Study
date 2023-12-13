// Two Sum
package leetcode.explore.hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashTable7_v {
    public static void main(String[] args) {
        HashTable7_v h = new HashTable7_v();

        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 2, 4};
        int[] nums3 = {3, 3};
        int[] nums4 = {1, 2, 4, 7, 12, 20, 33, 54};

//        System.out.println(Arrays.toString(h.twoSum(nums1, 9)));    // [0, 1]
//        System.out.println(Arrays.toString(h.twoSum(nums2, 6)));    // [1, 2]
//        System.out.println(Arrays.toString(h.twoSum(nums3, 6)));    // [0, 1]
        System.out.println(Arrays.toString(h.twoSum2(nums4, 45)));    // [4, 6]
    }

    // HashMap - 다른 사람의 풀이
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            if (numMap.containsKey(res)) {
                return new int[]{i, numMap.get(res)};
            }
            numMap.put(nums[i], i);
        }
        return null;
    }

    // brute force
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;
    }
}
