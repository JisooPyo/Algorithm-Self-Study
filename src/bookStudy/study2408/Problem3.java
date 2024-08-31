package bookStudy.study2408;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스 lv.1
 * 3. 두 개 뽑아서 더하기
 */
public class Problem3 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[set.size()];
        int index = 0;
        for (Integer i : set) {
            answer[index++] = i;
        }
        Arrays.sort(answer);
        return answer;
    }
}
