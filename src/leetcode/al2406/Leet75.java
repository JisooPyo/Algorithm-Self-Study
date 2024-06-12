package leetcode.al2406;

import java.util.Arrays;

/**
 * Medium
 * 75. Sort Colors
 *
 * Given
 * nums: n개의 객체 배열
 *       한 객체는 빨강, 흰생ㄱ, 파란색으로 되어 있다.
 * Return
 * 같은 컬러가 인접하도록 정렬하여라.
 * 색깔의 순서는 빨강, 흰색, 파랑으로 되도록 정렬한다.
 * 정수 0, 1, 2는 각각 빨강, 흰색, 파랑을 뜻한다.
 * 라이브러리의 정렬 함수를 사용하지 않고 문제를 풀어야 한다.
 */
public class Leet75 {
    public static void main(String[] args) {
        Leet75 l = new Leet75();

        int[] nums1 = {2, 0, 2, 1, 1, 0};
        int[] nums2 = {2, 0, 1};

        l.sortColors(nums1);
        System.out.println(Arrays.toString(nums1));
        l.sortColors(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    // 내 풀이 : 0ms
    // 풀이 시간 : 6m
    // 0, 1, 2의 개수를 세어 차례로 배열을 수정하였다.
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int index = 0;
        int color = 0;
        while (index < nums.length) {
            if (count[color] == 0) {
                color++;
                continue;
            }
            nums[index] = color;
            count[color]--;
            index++;
        }
    }
}
