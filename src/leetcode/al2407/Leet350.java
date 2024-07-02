package leetcode.al2407;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Easy
 350. Intersection of Two Arrays II

 정수 배열 nums1와 nums2가 주어진다.
 이 배열들의 교집합을 구하라.
 */
public class Leet350 {
    public static void main(String[] args) {
        Leet350 l = new Leet350();

        int[] nums1_1 = {1, 2, 2, 1}, nums2_1 = {2, 2};
        int[] nums1_2 = {4, 9, 5}, nums2_2 = {9, 4, 9, 8, 4};

        // [2,2]
        System.out.println(Arrays.toString(l.intersect(nums1_1, nums2_1)));
        // [4,9]
        System.out.println(Arrays.toString(l.intersect(nums1_2, nums2_2)));
    }

    // 내 풀이 : 1ms
    // List -> array 변환
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            count[nums1[i]]++;
        }

        List<Integer> intersectList = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (count[nums2[i]] > 0) {
                intersectList.add(nums2[i]);
                count[nums2[i]]--;
            }
        }

        int[] answer = new int[intersectList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = intersectList.get(i);
        }

        return answer;
    }

    // 다른 사람의 풀이 : 0ms
    // Arrays.copyOfRange() 이용
    public int[] intersectOther(int[] nums1, int[] nums2) {
        int[] arr = new int[1001];
        int[] result = new int[1001];

        for (int num : nums1) {
            arr[num]++;
        }

        int ctr = 0;
        for (int num : nums2) {
            if (arr[num] > 0) {
                result[ctr++] = num;
                arr[num]--;
            }
        }

        return Arrays.copyOfRange(result, 0, ctr);
    }
}
