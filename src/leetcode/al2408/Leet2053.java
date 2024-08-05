package leetcode.al2408;

import java.util.HashSet;
import java.util.Set;

/**
 * Eaxy
 * 2053. Kth Distinct String in an Array
 *
 * "distinct string"은 배열에 오직 하나만 존재하는 문자열이다.
 *
 * 주어진 문자열 배열 arr, 정수 k가 주어진다.
 * arr에서 k번째 "distinct string"을 반환하라.
 * 만약 k개의 "distinct string"보다 적게 있다면 빈 문자열 ""을 반환하라.
 */
public class Leet2053 {
    public static void main(String[] args) {
        Leet2053 leet2053 = new Leet2053();

        String[] arr1 = {"d", "b", "c", "b", "c", "a"};
        String[] arr2 = {"aaa", "aa", "a"};
        String[] arr3 = {"a", "b", "a"};

        System.out.println(leet2053.kthDistinct(arr1, 2));   // "a"
        System.out.println(leet2053.kthDistinct(arr2, 1));   // "aaa"
        System.out.println(leet2053.kthDistinct(arr3, 3));   // ""
    }

    // 내 풀이: 10m
    public String kthDistinct(String[] arr, int k) {
        Set<String> distinctSet = new HashSet<>();
        Set<String> notDistinctSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (distinctSet.contains(arr[i])) {
                distinctSet.remove(arr[i]);
                notDistinctSet.add(arr[i]);
            }
            if (!distinctSet.contains(arr[i]) && !notDistinctSet.contains(arr[i])) {
                distinctSet.add(arr[i]);
            }
        }
        if (distinctSet.size() < k) {
            return "";
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (distinctSet.contains(arr[i])) {
                count++;
            }
            if (count == k) {
                return arr[i];
            }
        }
        return "";
    }
}
