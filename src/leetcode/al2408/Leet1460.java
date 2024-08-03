package leetcode.al2408;

import java.util.Set;

/**
 * Easy
 * 1460. Make Two Arrays Equal by Reversing Subarrays
 *
 * 길이가 같은 두 정수 배열 target과 arr이 주어진다.
 * 한 스텝으로 arr의 비지 않은 subarray를 선택해서 뒤집을 수 있다.
 * 스텝은 몇 번이든 행하는 것이 허락되어진다.
 * arr을 target과 똑같이 맞출 수 있다면 true, 아니면 false를 반환하라.
 */
public class Leet1460 {
    public static void main(String[] args) {
        Leet1460 leet1460 = new Leet1460();
        int[] target1 = {1, 2, 3, 4};
        int[] arr1 = {2, 4, 1, 3};
        int[] target2 = {7};
        int[] arr2 = {7};
        int[] target3 = {3, 7, 9};
        int[] arr3 = {3, 7, 11};

        System.out.println(leet1460.canBeEqual(target1, arr1));     // true
        System.out.println(leet1460.canBeEqual(target2, arr2));     // true
        System.out.println(leet1460.canBeEqual(target3, arr3));     // false
    }

    // 내 풀이: 1ms
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] count = new int[1001];
        for (int i : arr) {
            count[i]++;
        }
        for (int i : target) {
            count[i]--;
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
