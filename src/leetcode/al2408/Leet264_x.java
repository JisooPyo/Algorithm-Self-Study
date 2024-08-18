package leetcode.al2408;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Medium
 * 264. Ugly Number II
 *
 * ugly number 은 소인수가 2, 3, 5로만 이루어진 양의 정수입니다.
 * 정수 n이 주어질 때, n번째 ugly number 을 반환하세요.
 */
public class Leet264_x {
    public static void main(String[] args) {
        Leet264_x l = new Leet264_x();

        // System.out.println(l.nthUglyNumber2(10));    // 12
        // System.out.println(l.nthUglyNumber2(1));     // 1
        System.out.println(l.nthUglyNumberOtherDP(1690));
        // l.nthUglyNumber(1690);  // 2123366400
    }

    // 0ms 풀이
    /*
    class Ugly {
        public int[] nums = new int[1690];

        Ugly() {
            nums[0] = 1;
            int ugly, i2 = 0, i3 = 0, i5 = 0;

            for (int i = 1; i < 1690; i++) {
                ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
                nums[i] = ugly;

                if (ugly == nums[i2] * 2)
                    ++i2;
                if (ugly == nums[i3] * 3)
                    ++i3;
                if (ugly == nums[i5] * 5)
                    ++i5;

            }
        }
    }

    class Solution {
        public static Ugly u = new Ugly();

        public int nthUglyNumber(int n) {
            return u.nums[n - 1];
        }
    }
    */

    // 다른 사람의 풀이: DP
    // Runtime: 7ms
    public int nthUglyNumberOtherDP(int n) {
        int[] primes = {2, 3, 5};  // Initialize the primes array
        int[] indices = {0, 0, 0}; // Initialize indices for multiples of 2, 3, 5
        List<Integer> uglyArr = new ArrayList<>();  // Initialize the ugly number array with 1
        uglyArr.add(1);

        for (int i = 1; i < n; ++i) {
            // Calculate the next possible ugly numbers
            int[] nextUglies = {
                uglyArr.get(indices[0]) * primes[0],
                uglyArr.get(indices[1]) * primes[1],
                uglyArr.get(indices[2]) * primes[2]
            };
            int minValue = Math.min(nextUglies[0], Math.min(nextUglies[1], nextUglies[2]));  // Find the smallest value
            uglyArr.add(minValue);  // Append the smallest value to uglyArr

            // Update indices for primes that generated the current min_value
            for (int j = 0; j < 3; ++j) {
                if (nextUglies[j] == minValue) {
                    indices[j]++;
                }
            }
        }

        return uglyArr.get(n - 1);
    }

    // 다른 사람의 풀이: Heap 이용
    // Runtime: 51ms
    public int nthUglyNumberOther(int n) {
        int[] primes = {2, 3, 5};
        PriorityQueue<Long> uglyHeap = new PriorityQueue<>();
        HashSet<Long> visited = new HashSet<>();

        uglyHeap.add(1L);
        visited.add(1L);

        long curr = 1L;
        for (int i = 0; i < n; i++) {
            curr = uglyHeap.poll();
            for (int prime : primes) {
                long new_ugly = curr * prime;
                if (!visited.contains(new_ugly)) {
                    uglyHeap.add(new_ugly);
                    visited.add(new_ugly);
                }
            }
        }
        return (int)curr;
    }

    // 내 풀이 2: Memory Limit Exceeded
    // 1690 : 847ms
    public int nthUglyNumber2(int n) {
        boolean[] dp = new boolean[2123366401];
        dp[1] = true;
        for (int i = 1; i <= (dp.length - 1) / 2; i++) {
            dp[2 * i] = true;
        }
        for (int i = 1; i < (dp.length - 1) / 3; i++) {
            if (!dp[3 * i]) {
                dp[3 * i] = true;
            }
        }
        for (int i = 1; i < (dp.length - 1) / 5; i++) {
            if (!dp[5 * i]) {
                dp[5 * i] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i]) {
                count++;
            }
            if (count == n) {
                return i;
            }
        }
        return 0;
    }

    // 내 풀이 1: Time Limit Exceeded
    // 1690 : 7787ms
    public int nthUglyNumber1(int n) {
        int count = 0;
        int i = 1;
        while (count < n) {
            if (isUglyNumber(i)) {
                count++;
            }
            i++;
        }
        return i - 1;
    }

    public boolean isUglyNumber(int num) {
        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }
}
