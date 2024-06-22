package leetcode.al2406;

import java.util.Arrays;

/**
 Medium
 1248. Count Number of Nice Subarrays

 Given
 nums : 정수 배열
 k : 정수

 만약 k개의 홀수가 있다면 연속된 부분집합은 nice 하다고 불린다.

 Return
 nice 한 부분집합의 수를 구하라.
 */
public class Leet1248_x {
    public static void main(String[] args) {
        Leet1248_x l = new Leet1248_x();

        int[] nums1 = {1, 1, 2, 1, 1};
        int k1 = 3;
        int[] nums2 = {2, 4, 6};
        int k2 = 1;
        int[] nums3 = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k3 = 2;

        // System.out.println(l.numberOfSubarrays(nums1, k1));     // 2
        // System.out.println(l.numberOfSubarrays(nums2, k2));     // 0
        System.out.println(l.numberOfSubarrays(nums3, k3));     // 16
    }

    // 내 풀이
    // Sliding Window로 풀면 되겠네~ 근데 어떻게 풀지..?

    // 다른 사람의 풀이 : 3ms
    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        // index : 홀수의 개수, value : 홀수의 개수가 index 개인 원소 개수
        // ex3. [4, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0]
        int[] count = new int[len + 1];
        // right - left 했을 때 left 에서 아무것도 안 빼는 경우 한 가지 더하기 해주기
        count[0] = 1;
        int ans = 0, temp = 0;
        for (int num : nums) {
            temp += num & 1;       // num & 1 : num 이 홀수이면 1 짝수이면 0
            if (temp >= k) {
                ans += count[temp - k];
            }
            count[temp]++;
        }
        System.out.println("count = " + Arrays.toString(count));
        return ans;
    }
}
