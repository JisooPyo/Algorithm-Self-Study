package bookStudy.study2408;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 2. 배열 제어하기
 *
 * 정수 배열을 하나 받습니다.
 * 배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환하는 solution() 합수를 구현하세요.
 */
public class Problem2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 2, 2, 1, 3, 4})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
    }

    // 내 풀이
    private static int[] solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        Integer[] result = new Integer[set.size()];
        int index = 0;
        for (Integer i : set) {
            result[index++] = i;
        }
        Arrays.sort(result, (a, b) -> b - a);

        int[] res = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            res[i] = result[i];
        }
        return res;
    }

    // 책 풀이
    private int[] bookSolution(int[] nums) {
        Integer[] result = Arrays.stream(nums).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    // 책 풀이 2
    private int[] bookSolution2(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : nums) {
            set.add(num);
        }
        int[] res = new int[set.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = set.pollFirst();
        }
        return res;
    }
}
