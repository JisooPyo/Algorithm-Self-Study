package leetcode.al2406;

import java.util.LinkedList;

/**
 Medium
 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit

 Given
 nums : 정수 배열
 limit : 정수

 Return
 가장 긴 non-empty 부분집합의 크기를 구하여라.
 이 부분집합의 모든 두 원소 사이 절대값은 limit 보다 적거나 같아야 한다.
 */
public class Leet1438_x {
    public static void main(String[] args) {
        Leet1438_x l = new Leet1438_x();

        int[] nums1 = {8, 2, 4, 7};
        int[] nums2 = {10, 1, 2, 4, 7, 2};
        int[] nums3 = {4, 2, 2, 2, 4, 4, 2, 2};

        System.out.println(l.longestSubarray(nums1, 4));    // 2
        System.out.println(l.longestSubarray(nums2, 5));    // 4
        System.out.println(l.longestSubarray(nums3, 0));    // 3
    }

    // 내 풀이
    // 답은 1 이상
    // 각 부분집합의 max value 와 min value 를 구하면 될 것 같다.
    // 근데 어떻게..?

    // 다른 사람의 풀이 : 22ms
    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> increase = new LinkedList<>();
        LinkedList<Integer> decrease = new LinkedList<>();

        int max = 0;    // 가장 긴 부분배열 길이 저장
        int left = 0;   // 현재 부분 배열의 시작 인덱스

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            // increase 업데이트
            // increase 가 비어 있지 않고 increase 의 마지막 원소가 nums[i]보다 적다면 마지막 원소를 제거
            while (!increase.isEmpty() && n < increase.getLast()) {
                increase.removeLast();
            }
            increase.add(n);

            // decrease 업데이트
            // decrease 가 비어 있지 않고 decrease 의 마지막 원소가 nums[i]보다 크다면 마지막 원소를 제거
            while (!decrease.isEmpty() && n > decrease.getLast()) {
                decrease.removeLast();
            }
            decrease.add(n);

            // 현재 부분 배열이 조건을 만족하는지 확인.
            // 만족하지 않으면 부분 배열의 시작점을 앞으로 이동시킨다.
            while (decrease.getFirst() - increase.getFirst() > limit) {
                if (nums[left] == decrease.getFirst()) {
                    decrease.removeFirst();
                }
                if (nums[left] == increase.getFirst()) {
                    increase.removeFirst();
                }
                left++;
            }

            // 현재 부분 배열의 길이를 계산하고 최대 길이를 갱신
            int size = i - left + 1;
            max = Math.max(max, size);
        }

        return max;
    }
}
