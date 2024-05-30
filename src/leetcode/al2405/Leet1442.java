package leetcode.al2405;

import java.util.Arrays;

/**
 * Medium
 * 1442. Count Triplets That Can Form Two Arrays of Equal XOR
 *
 * Given
 * arr : 정수 배열
 * i, j, k : index, 0 <= i < j <= k < arr.length
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * - Note: ^는 XOR 비트연산자이다.
 *
 * Return
 * a == b인 (i, j, k) 쌍의 수를 구하라.
 */
public class Leet1442 {
    public static void main(String[] args) {
        Leet1442 l = new Leet1442();

        int[] arr1 = {2, 3, 1, 6, 7};
        int[] arr2 = {1, 1, 1, 1, 1};

        // (0,1,2), (0,2,2), (2,3,4), (2,4,4)
        System.out.println(l.countTriplets(arr1));  // 4
        System.out.println(l.countTriplets(arr2));  // 10
    }

    // hint1: 길이가 2 이상인 부분배열을 찾아 두 비지 않은 배열로 나누었을 때 첫번째 배열의 XOR이 두 번쩨의 것과 같아야 한다.
    // 이는 XOR = 0 인 부분배열을 찾는 것과 동일하다.
    public int countTriplets(int[] arr) {
        int count = 0;
        // XOR 값을 기록
        int[] xor = new int[arr.length];
        for (int i = 0; i < xor.length; i++) {
            xor[i] = arr[i];
            for (int j = i + 1; j < xor.length; j++) {
                xor[j] = xor[j - 1] ^ arr[j];
                // x부터 y까지 XOR = 0인 부분배열을 찾았으면 가능한 쌍의 개수는 (y - x)개이다.
                if (xor[j] == 0) {
                    count += (j - i);
                }
            }
        }
        return count;
    }
}
