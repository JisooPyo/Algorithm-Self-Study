package leetcode.al2406;

import java.util.Arrays;

/**
 * Medium
 * 945. Minimum Increment to Make Array Unique
 *
 * Given
 * nums : 정수 배열
 *
 * 한 움직임에 0 <= i < nums.length 인 index i 를 골라 nums[i]를 1증가시킬 수 있다.
 *
 * Return
 * nums 의 모든 값을 unique 하게 만드는 최소한의 움직임 수를 구하라.
 */
public class Leet945_x {
    public static void main(String[] args) {
        Leet945_x l = new Leet945_x();
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {3, 2, 1, 2, 1, 7};
        int[] nums3 = {0, 0};
        int[] nums4 = {1, 2, 2, 2};

        System.out.println(l.minIncrementForUnique(nums1));     // 1
        System.out.println(l.minIncrementForUnique(nums2));     // 6
        System.out.println(l.minIncrementForUnique(nums3));     // 1
        System.out.println(l.minIncrementForUnique(nums4));     // 3
    }

    // 내가 푼 풀이 : Time Limet Exceeded
    // 시간 초과가 났다. O(N)이지만 순회하면서 많은 연산을 하기 때문에 그런게 아닐까
    public int minIncrementForUnique(int[] nums) {
        int[] numsCount = new int[100001];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            numsCount[num]++;
        }

        int steps = 0;
        int index = min;
        int right = min;
        while (index <= max) {
            if (numsCount[index] <= 1) {
                index++;
                continue;
            }
            if (right <= index) {
                right = index + 1;
            } else {
                right++;
            }
            while (right < numsCount.length) {
                if (numsCount[right] != 0) {
                    right++;
                    continue;
                }
                numsCount[right]++;
                numsCount[index]--;
                steps += right - index;
                break;
            }
        }
        return steps;
    }

    // 가장 많은 사람들의 풀이 : O(N log N)
    // 정렬하고 나서 한 칸씩 땡기는 방법
    public int minIncrementForUniqueMany(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return ans;
    }

    // 가장 빠른 풀이
    // 정렬을 이용하지 않고 나와 같이 index = 숫자 value = 숫자 count 를 이용해서 풀었다.
    // count 한 이후에는 하나하나씩 넘기는 작업은 똑같이 했고, 다만 이를 max까지만 진행하였다.
    // max가 5인데 여기서 만약에 값이 3이 되면 6과 7에 하나씩 분배해야 되므로 1+2가 된다.
    // 즉 max의 값이 n이 나오면 1에서 n-1까지 더한 값을 return해주면 된다.
    public int minIncrementForUniqueFastest(int[] nums) {
        int minInc = 0;
        int n = -1;
        for (int i : nums)
            if (n < i)
                n = i;
        int[] freq = new int[n + 1];
        for (int i : nums) {
            freq[i]++;
        }

        for (int i = 0; i < n; i++) {
            if (freq[i] > 1) {
                freq[i + 1] += freq[i] - 1;
                minInc += freq[i] - 1;
            }
        }
        minInc += (freq[n] - 1) * (freq[n]) / 2;
        return minInc;
    }

}
