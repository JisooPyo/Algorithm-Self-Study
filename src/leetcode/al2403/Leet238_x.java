package leetcode.al2403;

import java.util.Arrays;

public class Leet238_x {
    public static void main(String[] args) {
        Leet238_x l = new Leet238_x();
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(l.productExceptSelf(nums1)));    // [24, 12, 8, 6]
        System.out.println(Arrays.toString(l.productExceptSelf(nums2)));    // [0, 0, 9, 0, 0]
    }

    // 조건 1: 시간 복잡도는 O(N)일 것
    // 조건 2: 나누기 연산을 사용하지 않을 것

    // 첫번째
    // 다 곱한 뒤에 원소 하나하나 나누기하기
    // 조건 1은 만족하지만, 조건 2를 만족하지 못함

    // 곱하기만 쓰면 O(N)이 힘들고
    // O(N)을 적용하려면 나누기가 필요해 보이는데 ;ㅅ;

    // 다른 사람의 풀이
    // 다음 방식으로 풀이가 진행된다.
    // 1. 접두사 곱을 구하면서 반환할 배열에 저장한다.
    // 2. 접미사 곱을 구하면서 반환할 배열에 곱한다.
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] products = new int[length];

        int prefixProduct = 1;
        for (int i = 0; i < length; i++) {
            products[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        int suffixProduct = 1;
        for (int i = length - 1; i >= 0; i--) {
            products[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return products;
    }
}
