package bookStudy.study2408;

import java.util.Arrays;

/**
 * 프로그래머스 lv.1
 * 4. 모의고사
 */
public class Problem4 {
    public static void main(String[] args) {
        Problem4 p = new Problem4();
        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(p.solution(answers1)));  // [1]
        System.out.println(Arrays.toString(p.solution(answers2)));  // [1, 2, 3]
    }

    int[] peek1 = {1, 2, 3, 4, 5};
    int[] peek2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] peek3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] count = new int[4];
        for (int i = 0; i < answers.length; i++) {
            if (peek1[i % 5] == answers[i]) {
                count[1]++;
            }
            if (peek2[i % 8] == answers[i]) {
                count[2]++;
            }
            if (peek3[i % 10] == answers[i]) {
                count[3]++;
            }
        }
        int maxScore = Math.max(Math.max(count[1], count[2]), count[3]);
        int howMany = 0;
        for (int i = 1; i <= 3; i++) {
            if (count[i] == maxScore) {
                howMany++;
            }
        }
        int[] answer = new int[howMany];
        int index = 0;
        for (int i = 1; i <= 3; i++) {
            if (count[i] == maxScore) {
                answer[index++] = i;
            }
        }
        return answer;
    }
}

/*
테스트 1 〉	통과 (0.02ms, 72.1MB)
테스트 2 〉	통과 (0.04ms, 74.8MB)
테스트 3 〉	통과 (0.03ms, 75.8MB)
테스트 4 〉	통과 (0.03ms, 66.2MB)
테스트 5 〉	통과 (0.05ms, 75.3MB)
테스트 6 〉	통과 (0.05ms, 80.3MB)
테스트 7 〉	통과 (0.33ms, 79.2MB)
테스트 8 〉	통과 (0.13ms, 77.4MB)
테스트 9 〉	통과 (0.66ms, 82.3MB)
테스트 10 〉	통과 (0.43ms, 74MB)
테스트 11 〉	통과 (1.06ms, 86.2MB)
테스트 12 〉	통과 (0.82ms, 73MB)
테스트 13 〉	통과 (0.06ms, 77.8MB)
테스트 14 〉	통과 (0.64ms, 78.5MB)
 */
