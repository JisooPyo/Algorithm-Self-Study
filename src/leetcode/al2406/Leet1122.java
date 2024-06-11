package leetcode.al2406;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Easy
 * 1122. Relative Sort Array
 * Given
 * arr1, arr2 : 정수 배열
 *              arr2의 원소들은 겹치지 않는다.
 *              arr2의 원소들은 arr1에 존재한다.
 *
 * arr1의 원소들의 상대적 순서가 arr2와 같게끔 arr1의 원소들을 정렬하라.
 * arr2에서 나오지 않았던 원소들은 arr1 끝에서 오름차순으로 정렬하여라.
 */
public class Leet1122 {
    public static void main(String[] args) {
        Leet1122 l = new Leet1122();

        int[] arr1_1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2_1 = {2, 1, 4, 3, 9, 6};

        int[] arr1_2 = {28, 6, 22, 8, 44, 17};
        int[] arr2_2 = {22, 28, 8, 6};

        // [2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19]
        System.out.println(Arrays.toString(l.relativeSortArray(arr1_1, arr2_1)));
        // [22, 28, 8, 6, 17, 44]
        System.out.println(Arrays.toString(l.relativeSortArray(arr1_2, arr2_2)));
    }

    // 내 풀이 : 3ms
    // 걸린 시간 : 20m
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // arr2 원소 저장 - 값, index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        // 문제의 기준에 맞게 정렬하기 위해 새로운 클래스 생성
        Element[] elements = new Element[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            // arr2에 존재하지 않으면
            // 최대 index 999보다 큰 1000을 index로(배열 끝에 놓기 위해), 값을 value로 넣어준다.
            // arr2에 존재하면
            // index와 value를 넣어준다.
            if (map.get(arr1[i]) == null) {
                Element element = new Element(1000, arr1[i]);
                elements[i] = element;
            } else {
                Element element = new Element(map.get(arr1[i]), arr1[i]);
                elements[i] = element;
            }
        }

        // 문제의 기준에 맞게 정렬
        Arrays.sort(elements);

        // 정렬된 배열 elements 에서 값만 가져와서 return 한다.
        int[] res = new int[elements.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = elements[i].value;
        }
        return res;
    }

    public class Element implements Comparable<Element> {
        int index;
        int value;

        public Element(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Element o) {
            int value = this.index - o.index;
            if (value != 0) {
                return value;
            }
            return this.value - o.value;
        }
    }

    // 다른 사람의 풀이 : 0ms
    public int[] relativeSortArrayOther(int[] arr1, int[] arr2) {
        // arr1 원소를 저장
        int[] cnt = new int[1001];
        for (int i : arr1) {
            cnt[i]++;
        }
        // arr2를 돌면서 ans를 채워넣는다.
        int[] ans = new int[arr1.length];
        int i = 0;
        for (int n : arr2) {
            while (cnt[n] > 0) {
                ans[i] = n;
                cnt[n]--;
                i++;
            }
        }
        // cnt를 돌면서 ans를 채워넣는다.
        for (int j = 0; j < cnt.length; j++) {
            while (cnt[j] > 0) {
                ans[i] = j;
                cnt[j]--;
                i++;
            }
        }
        return ans;
    }
}
