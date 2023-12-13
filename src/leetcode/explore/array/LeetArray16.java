package leetcode.explore.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetArray16 {
    public static void main(String[] args) {
        LeetArray16 la16 = new LeetArray16();

        int[] nums1 = {3, 2, 1};
        int[] nums2 = {1, 2};
        int[] nums3 = {2, 2, 3, 1};

        System.out.println(la16.thirdMax(nums1));    // 1
        System.out.println(la16.thirdMax(nums2));    // 2
        System.out.println(la16.thirdMax(nums3));    // 1

        int[] nums4 = {1, 1, 2};
        System.out.println(la16.thirdMax(nums4));    // 2

        int[] nums5 = {5, 2, 2};
        System.out.println(la16.thirdMax(nums5));    // 5

        int[] nums6 = {1, 2, 2, 5, 3, 5};
        System.out.println(la16.thirdMax(nums6));    // 2

        int[] nums7 = {1, 2, -2147483648};
        System.out.println(la16.thirdMax(nums7));    // -2147483648
    }

    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int[] distinct = new int[set.size()];
        int index = 0;
        for (Integer i : set) {
            distinct[index] = i;
            index++;
        }
        Arrays.sort(distinct);
        return distinct.length < 3 ? distinct[distinct.length - 1] : distinct[distinct.length - 3];

    }

    // first, second, third 생각하고 구현이 잘 안되어서 포기했는데 이렇게 푼 사람이 있어서 기록
// Integer.MIN_VALUE가 아니라 Long.MIN_VALUE로 설정
    public int otherSol(int[] nums) {

        long max = Long.MIN_VALUE;
        long secondmax = Long.MIN_VALUE;
        long thirdmax = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                thirdmax = secondmax;
                secondmax = max;
                max = nums[i];
            } else if (nums[i] > secondmax && nums[i] < max) {
                thirdmax = secondmax;
                secondmax = nums[i];
            } else if (nums[i] > thirdmax && nums[i] < secondmax) {
                thirdmax = nums[i];
            }
        }
        return thirdmax == Long.MIN_VALUE ? (int) max : (int) thirdmax;
    }
}