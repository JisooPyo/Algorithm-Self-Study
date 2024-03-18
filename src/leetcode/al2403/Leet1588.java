package leetcode.al2403;

import java.util.Arrays;

public class Leet1588 {
    public static void main(String[] args) {
        Leet1588 l = new Leet1588();

        int[] arr1 = {1, 4, 2, 5, 3};
        int[] arr2 = {1, 2};
        int[] arr3 = {10, 11, 12};

        System.out.println(l.sumOddLengthSubarrays(arr1));      // 58
        System.out.println(l.sumOddLengthSubarrays(arr2));      // 3
        System.out.println(l.sumOddLengthSubarrays(arr3));      // 66
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int[] prefixSum = new int[arr.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        int length = 1;
        int sum = 0;
        while (length < prefixSum.length) {
            for (int i = 0; i + length < prefixSum.length; i++) {
                sum += prefixSum[i + length] - prefixSum[i];
            }
            length += 2;
        }

        return sum;
    }
}
