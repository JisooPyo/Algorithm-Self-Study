package leetcode.explore.array;

import java.util.ArrayList;
import java.util.List;

public class LeetArray17 {
    public static void main(String[] args) {
        LeetArray17 la17 = new LeetArray17();

        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
//		[1, 2, 2, 3, 3, 4, 7, 8]
//		[1, 2, 3, 4, 5, 6, 7, 8]
        int[] nums2 = {1, 1};

        System.out.println(la17.findDisappearedNumbers2(nums1));    // [5, 6]
        System.out.println(la17.findDisappearedNumbers2(nums2));    // [2]
    }

    // Follow up: Could you do it without extra space and
    // in O(n) runtime? You may assume the returned list does not count as extra space.

    // hint1
    // This is a really easy problem if you decide to use additional memory.
    // For those trying to write an initial solution using additional memory, think counters!
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] allNumbers = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            allNumbers[nums[i]]++;
        }
        List<Integer> disappear = new ArrayList<>();
        for (int i = 1; i < allNumbers.length; i++) {
            if (allNumbers[i] == 0) {
                disappear.add(i);
            }
        }
        return disappear;
    }

    // hint2
    // However, the trick really is to not use any additional space than what is already available to use.
    // Sometimes, multiple passes over the input array help find the solution.
    // However, there's an interesting piece of information in this problem
    // that makes it easy to re-use the input array itself for the solution.

    // hint3
    // The problem specifies that the numbers in the array will be in the range [1, n]
    // where n is the number of elements in the array.
    // Can we use this information and modify the array in-place somehow to find what we need?

    // 다른 사람의 풀이
    // extra space를 쓰지 않으며 시간 복잡도가 O(n)인 풀이
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new ArrayList<>();

        // 숫자를 정렬하되 nums[index] = index+1 이 되도록 정렬한다.
        int i = 0;
        while (i < nums.length) {
            int position = nums[i] - 1;
            if (nums[i] != nums[position]) {
                int temp = nums[i];
                nums[i] = nums[position];
                nums[position] = temp;
            } else {
                i++;
            }
        }

        // nums[index] = index + 1 이 아닌 것을 골라 list에 담는다.
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }

        return list;
    }
}
