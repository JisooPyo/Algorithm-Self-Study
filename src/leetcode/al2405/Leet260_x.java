package leetcode.al2405;

import java.util.Arrays;

/**
 * Medium
 * 260. Single Number III
 *
 * Given
 * nums: 정수 배열
 *       두 원소는 단 한 번, 모든 다른 원소는 두 개씩 존재한다.
 *
 * Return
 * 한 번 나타나는 두 원소를 찾아라.(어떤 순서로든 상관없음)
 *
 * Note.
 * 선형 실행 복잡도로 실행되고 상수 추가 공간만 사용하는 알고리즘을 작성해야 한다.
 */
public class Leet260_x {
    public static void main(String[] args) {
        Leet260_x l = new Leet260_x();

        int[] nums1 = {1, 2, 1, 3, 2, 5};
        int[] nums2 = {-1, 0};
        int[] nums3 = {0, 1};

        System.out.println(Arrays.toString(l.singleNumber(nums1)));     // [5, 3]
        System.out.println(Arrays.toString(l.singleNumber(nums2)));     // [0, -1]
        System.out.println(Arrays.toString(l.singleNumber(nums3)));     // [0, 1]
    }

    // 아이디어
    // 다 XOR 연산을 해주면 답을 A, B라고 했을 때, XOR(A, B)값을 얻을 수 있다.
    // 이 다음엔 어떡하지?

    // 다른 사람의 풀이
    // 답을 A와 B라 한다.
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // 처음으로 1이 나오는 자리를 찾는다. A와 B가 비트가 다른 지점.
        int mask = 1;
        while ((xor & mask) == 0) {
            mask <<= 1;
        }

        // A의 mask 자리가 0, B의 mask 자리가 1이라고 가정하면
        // mask 자리가 0인 그룹에는 XOR 연산을 했을 시 A가 들어가고
        int num1 = 0;
        // mask 자리가 1인 그룹에는 XOR 연산을 했을 시 B가 들어간다.
        int num2 = 0;

        for (int num : nums) {
            if ((num & mask) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }
}
