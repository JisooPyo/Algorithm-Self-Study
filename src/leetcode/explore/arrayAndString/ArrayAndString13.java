package leetcode.explore.arrayAndString;

import java.util.TreeSet;

public class ArrayAndString13 {
    public static void main(String[] args) {
        ArrayAndString13 aas13 = new ArrayAndString13();

        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int[] nums2 = {1, 4, 4};
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] nums4 = {12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};

        System.out.println(aas13.minSubArrayLen(7, nums1));     // 2
        System.out.println(aas13.minSubArrayLen(4, nums2));     // 1
        System.out.println(aas13.minSubArrayLen(11, nums3));    // 0
        System.out.println(aas13.minSubArrayLen(213, nums4));    // 8
    }

    /**
     * Follow up:
     * If you have figured out the O(n) solution,
     * try coding another solution of which the time complexity is O(n log(n)).
     *
     * 이진 탐색을 이용
     * 이진 탐색은 오름차순으로 정렬되어 있는 배열에서 쓸 수 있다.
     * 0에서 i번째 index까지의 합을 int[] sum를 생성하여 sum[i]에 저장해서 쓸 수 있다.
     */

    /**
     * 다른 사람이 푼 풀이를 보고 treeset 대신
     * 변수에 Math.min()을 이용하여 최솟값을 저장하게끔 바꿔보았다.
     * time complexity: O(n)
     * runtime: 1ms
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums[0] > target) return 1;

        int left = 0;
        int right = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target) {
                right = i;
                break;
            }
        }
        if (right == 0) {
            return 0;
        }

        int length = right - left + 1;

        while (true) {
            if (sum >= target) {
                length = Math.min(right - left + 1, length);
                sum -= nums[left++];
            } else {
                right++;
                if (right == nums.length) break;
                sum += nums[right];
            }
        }
        return length;
    }


    /**
     * time complexity: O(n)
     * runtime: 4ms
     */
    public int minSubArrayLenFirst(int target, int[] nums) {
        if (nums[0] > target) return 1;

        int left = 0;
        int right = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target) {
                right = i;
                break;
            }
        }
        if (right == 0) {
            return 0;
        }

        TreeSet<Integer> lengthSet = new TreeSet<>();

        while (true) {
            if (sum >= target) {
                lengthSet.add(right - left + 1);
                sum -= nums[left++];
            } else {
                right++;
                if (right == nums.length) break;
                sum += nums[right];
            }
        }
        return lengthSet.first();
    }


    /**
     * 다른 사람이 푼 풀이
     * time complexity: O(n)
     * runtime: 4ms
     * 로직은 비슷한데 나는 treeset에 length들을 저장했고,
     * 이 풀이에서는 변수 res에 Math.min()을 이용하여 최솟값을 저장하였다.
     */
    public int minSubArrayLenOther(int target, int[] nums) {
        int i = 0;
        int j = 0;

        int sum = nums[0];
        int res = Integer.MAX_VALUE;
        while (j <= nums.length) {
            while (sum >= target) {
                // 변수에 Math.min()을 사용하여 최솟값을 저장하였다.
                res = Math.min(res, (j - i + 1));
                sum -= nums[i];
                i++;
            }
            // 내가 for문으로 따로 뺐던 부분.
            j++;
            if (j < nums.length) {
                sum += nums[j];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }


    /**
     * time complexity: o(n^2)
     * time limit exceeded
     */
    public int minSubArrayLenWrong(int target, int[] nums) {
        TreeSet<Integer> lengthSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = target;
            for (int j = i; j < nums.length; j++) {
                sum -= nums[j];
                if (sum <= 0) {
                    lengthSet.add(j - i + 1);
                    break;
                }
            }
        }
        return lengthSet.size() == 0 ? 0 : lengthSet.first();
    }

}
