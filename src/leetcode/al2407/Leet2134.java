package leetcode.al2407;

/**
 * Medium
 * 2134. Minimum Swaps to Group All 1's Together II
 *
 * 스왑은 배열에서 두 개의 서로 다른 위치에 있는 값을 교환하는 것으로 정의됩니다.
 * 원형 배열은 배열의 첫 번째 요소와 마지막 요소가 인접해 있는 배열로 정의됩니다.
 * 이진 원형 배열 nums가 주어졌을 때, 배열에 존재하는 모든 1을 임의의 위치에 모으기 위해 필요한 최소 스왑 횟수를 반환하세요.
 */
public class Leet2134 {
    public static void main(String[] args) {
        Leet2134 l = new Leet2134();

        int[] nums1 = {0, 1, 0, 1, 1, 0, 0};
        int[] nums2 = {0, 1, 1, 1, 0, 0, 1, 1, 0};
        int[] nums3 = {1, 1, 0, 0, 1};

        System.out.println(l.minSwaps(nums1));  // 1
        System.out.println(l.minSwaps(nums2));  // 2
        System.out.println(l.minSwaps(nums3));  // 0
    }

    // 내 풀이 : 7ms
    // 걸린 시간 : 23m
    // 알고리즘 : sliding window
    public int minSwaps(int[] nums) {
        // 1의 개수 구하기
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            }
        }
        if (count == 0 || count == 1 || count == nums.length || count == nums.length - 1) {
            return 0;
        }

        // 0의 개수가 적은 구간 구하기
        int min = 0;
        // 1) 첫 구간에서의 0의 개수 구하기
        for (int i = 0; i < count; i++) {
            if (nums[i] == 0) {
                min++;
            }
        }
        if (min == 0) {
            return 0;
        }
        int zeroCount = min;
        // 2) 모든 구간에서의 최소 0의 개수 구하기
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeroCount--;
            }
            int endIndex = i + count;
            if (endIndex > len - 1) {
                endIndex -= len;
            }
            if (nums[endIndex] == 0) {
                zeroCount++;
            }
            min = Math.min(zeroCount, min);
            if (min == 0) {
                return 0;
            }
        }
        return min;
    }
}
