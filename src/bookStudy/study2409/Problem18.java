package bookStudy.study2409;

import java.util.HashSet;
import java.util.Set;

/**
 * 18. 두 개의 수로 특정값 만들기
 */
public class Problem18 {
    public static void main(String[] args) {
        Problem18 p = new Problem18();

        int[] arr1 = {1, 2, 3, 4, 8};
        int[] arr2 = {2, 3, 5, 9};

        System.out.println(p.solution(arr1, 6));    // true
        System.out.println(p.solution(arr2, 10));   // false
    }

    // 책 풀이
    // 시간복잡도: O(N)
    public boolean solutionBook(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            if (set.contains(target - i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    // 내 풀이
    // 시간복잡도: O(N^2)
    public boolean solution(int[] arr, int target) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
