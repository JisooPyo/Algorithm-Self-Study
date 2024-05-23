package leetcode.al2405;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2597. The Number of Beautiful Subsets
 *
 * Given
 * nums: 양의 정수 배열
 * k : 양의 정수
 *
 * 절대 거리가 k인 두 정수를 포함하지 않으면 nums의 subset이 beautiful하다라고 가정한다.
 *
 * Return
 * nums의 비어 있지 않은 beautiful한 subset의 개수를 구하라.
 */
public class Leet2597 {
    public static void main(String[] args) {
        Leet2597 l = new Leet2597();

        int[] nums1 = {2, 4, 6};
        int[] nums2 = {1};
        int[] nums3 = {4, 2, 5, 9, 10, 3};
        int[] nums4 = {10, 4, 5, 7, 2, 1};
        int[] nums5 = {1, 2, 3, 3};

        // [2], [4], [6], [2, 6]
        // System.out.println(l.beautifulSubsets(nums1, 2));   // 4
        // [1]
        // System.out.println(l.beautifulSubsets(nums2, 1));   // 1
        // 1 -> 6 / 2 -> 11 / 3 -> 6
        // System.out.println(l.beautifulSubsets(nums3, 1));   // 23
        // System.out.println(l.beautifulSubsets(nums4, 3));   // 23
        // [1, 3], [1, 3], [3, 3], [1, 3, 3]
        System.out.println(l.beautifulSubsets(nums5, 1));   // 23
    }

    // 내 풀이 : 5381ms ㄴㅇㄱ...
    int count;
    int k;
    int[] nums;
    int len;

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        count = 0;
        this.k = k;
        this.nums = nums;
        this.len = nums.length;

        // i : 부분집합 size
        count += len;
        for (int i = 2; i <= len; i++) {
            int cur = count;
            // j : 첫 시작 원소
            for (int j = 0; j <= len - i; j++) {
                boolean[] isK = new boolean[len];
                kCheck(isK, j);
                res(i, j, isK);
            }
            if (count - cur == 0) {
                break;
            }
            System.out.println("i = " + i);
            System.out.println("부분집합 개수 = " + (count - cur));
        }
        return count;
    }

    private void kCheck(boolean[] isK, int index) {
        for (int i = index + 1; i < len; i++) {
            if (Math.abs(nums[i] - nums[index]) == k) {
                isK[i] = true;
            } else if (Math.abs(nums[i] - nums[index]) > k) {
                return;
            }
        }
    }

    private void res(int size, int start, boolean[] isK) {
        if (size == 1) {
            count++;
            return;
        }
        for (int i = start + 1; i < len; i++) {
            if (!isK[i]) {
                boolean[] copyArr = Arrays.copyOf(isK, isK.length);
                kCheck(copyArr, i);
                res(size - 1, i, copyArr);
            }
        }
    }

    // 다른 사람의 풀이: 9ms
    // 어렵다....!!!
    public int beautifulSubsetsOther(int[] nums, int k) {


        // 원소 수 세기
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        // res: 아름다운 부분집합의 총 개수
        int res = 1, prev = 0, prevPrev = 0;

        // 숫자
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            int cur = e.getKey();

            // cur-k가 존재하면 이는 이미 고려된 숫자이므로 제외한다.
            if (m.containsKey(cur - k)) {
                continue;
            }

            prev = 0;

            // cur에서 시작하여 k 간격으로 숫자를 진행하며 아름다운 부분집합을 계산한다.
            // mod k 인것끼리 묶어서 계산해주는 것.
            while (m.containsKey(cur)) {
                prevPrev = prev;
                // 현재 숫자가 포함된 부분집합의 수
                prev = ((1 << m.get(cur)) - 1) * res;
                res += prevPrev;
                cur += k;
            }
            res += prev;
        }
        return res - 1;
    }
}
