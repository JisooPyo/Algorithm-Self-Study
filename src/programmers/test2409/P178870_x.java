package programmers.test2409;

import java.util.Arrays;

/**
 * 프로그래머스 lv.2
 * 연속된 부분 수열의 합
 */
public class P178870_x {
    public static void main(String[] args) {
        P178870_x p = new P178870_x();
        int[] sequence1 = {1, 2, 3, 4, 5};
        int[] sequence2 = {1, 1, 1, 2, 3, 4, 5};
        int[] sequence3 = {2, 2, 2, 2, 2};

        System.out.println(Arrays.toString(p.solution(sequence1, 7)));  // [2, 3]
        System.out.println(Arrays.toString(p.solution(sequence2, 5)));  // [6, 6]
        System.out.println(Arrays.toString(p.solution(sequence3, 6)));  // [0, 2]
    }

    public int[] solution(int[] sequence, int k) {
        int[] answer = {-1, -1};
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for (int end = 0; end < sequence.length; end++) {
            sum += sequence[end];

            while (sum > k && start <= end) {
                sum -= sequence[start];
                start++;
            }

            if (sum == k) {
                int length = end - start + 1;
                if (length < minLength || (length == minLength && start < answer[0])) {
                    minLength = length;
                    answer[0] = start;
                    answer[1] = end;
                }
            }
        }

        return answer;
    }
    /*
    통과. 최대 시간 15.04ms
     */

    public int[] solutionFail2(int[] sequence, int k) {
        int[] answer = new int[2];
        loop1:
        for (int i = 1; i <= sequence.length; i++) {
            int maxSum = 0;
            for (int j = sequence.length - i; j < sequence.length; j++) {
                maxSum += sequence[j];
            }
            if (maxSum < k) {
                continue;
            }
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += sequence[j];
            }

            if (sum == k) {
                answer[1] = i - 1;
                break;
            }

            for (int j = 1; j <= sequence.length - i; j++) {
                sum -= sequence[j - 1];
                sum += sequence[j - 1 + i];
                if (sum == k) {
                    answer[0] = j;
                    answer[1] = j - 1 + i;
                    break loop1;
                }
            }
        }
        return answer;
    }
    /*
    테스트 11, 16, 24, 25, 28, 29 > 실패 (시간 초과)
     */

    public int[] solutionFail1(int[] sequence, int k) {
        int[] answer = new int[2];
        loop1:
        for (int i = 1; i <= sequence.length; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += sequence[j];
            }

            if (sum == k) {
                answer[1] = i - 1;
                break;
            }

            for (int j = 1; j <= sequence.length - i; j++) {
                sum -= sequence[j - 1];
                sum += sequence[j - 1 + i];
                if (sum == k) {
                    answer[0] = j;
                    answer[1] = j - 1 + i;
                    break loop1;
                }
            }
        }
        return answer;
    }
    /*
    테스트 10, 11, 12, 13, 14, 15, 16, 24, 25, 26, 27, 28, 29, 30 〉	실패 (시간 초과)
     */
}
