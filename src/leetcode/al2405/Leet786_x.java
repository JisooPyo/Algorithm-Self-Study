package leetcode.al2405;

import java.util.Arrays;

/**
 * 786. K-th Smallest Prime Fraction
 *
 * Given
 * arr: 1과 소수를 포함하는 정렬된 정수 배열
 *      arr의 모든 정수는 unique하다.
 * k: 정수
 *
 * 0 <= i < j < arr.length의 모든 i와 j에서 분수 arr[i] / arr[j]를 생각해보자.
 * 이 때, k번째로 작은 분수를 반환하라.
 * 답은 answer[0] == arr[i], answer[1] == arr[j]이고 크기 2인 정수 배열의 형태로 반환하라.
 */
public class Leet786_x {
    public static void main(String[] args) {
        Leet786_x l = new Leet786_x();
        int[] arr1 = {1, 2, 3, 5};
        int[] arr2 = {1, 7};

        System.out.println(Arrays.toString(l.kthSmallestPrimeFraction(arr1, 3)));
        System.out.println(Arrays.toString(l.kthSmallestPrimeFraction(arr2, 1)));
    }

    // 내 풀이
    // 분수값을 다 저장한 후 k번째를 구하는 방법

    // 다른 사람 풀이
    // 1. 0에서 1까지 가능한 값 범위로 시작한다.
    // 2. 범위의 중간에 있는 값을 선택한다. 이를 "중간"이라고 한다.
    // 3. "중간"보다 작거나 같은 분수의 개수를 센다.
    // 4. 개수가 k와 같으면 k번째로 작은 분수를 찾은 것!
    // 5. 개수가 k보다 작으면 더 큰 분수를 검색해야 하므로 범위의 하한을 "중간"으로 업데이트한다.
    // 6. 개수가 k보다 크면 더 작은 부분을 검색해야 하므로 범위의 상한을 "중간"으로 업데이트한다.
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double left = 0, right = 1, mid;
        int[] res = new int[2];

        while (left <= right) {
            mid = left + (right - left) / 2;
            int j = 1, total = 0, num = 0, den = 0;
            double maxFrac = 0;
            for (int i = 0; i < n; ++i) {
                while (j < n && arr[i] >= arr[j] * mid) {
                    ++j;
                }

                total += n - j;

                if (j < n && maxFrac < arr[i] * 1.0 / arr[j]) {
                    maxFrac = arr[i] * 1.0 / arr[j];
                    num = i;
                    den = j;
                }
            }

            if (total == k) {
                res[0] = arr[num];
                res[1] = arr[den];
                break;
            }

            if (total > k) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return res;
    }
}
