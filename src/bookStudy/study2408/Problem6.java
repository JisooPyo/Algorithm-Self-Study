package bookStudy.study2408;

import java.util.Arrays;

/**
 * 프로그래머스 lv.1
 * 실패율
 */
public class Problem6 {
    public static void main(String[] args) {
        Problem6 p = new Problem6();
        int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] stages2 = {4, 4, 4, 4, 4};
        System.out.println(Arrays.toString(p.solution(5, stages1)));    // [3, 4, 2, 1, 5]
        System.out.println(Arrays.toString(p.solution(4, stages2)));    // [4, 1, 2, 3]
    }

    // 시간복잡도
    public int[] solution(int N, int[] stages) {
        int[] count = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            count[stages[i]]++;
        }

        Failure[] failures = new Failure[N];
        int people = stages.length;
        for (int i = 0; i < count.length - 2; i++) {
            if (people != 0) {
                failures[i] = new Failure(i + 1, (double)count[i + 1] / people);
            } else {
                failures[i] = new Failure(i + 1, 0);
            }
            people -= count[i + 1];
        }

        Arrays.sort(failures, (a, b) ->
            Double.compare(
                b.failure, a.failure) == 0
                ? a.stage - b.stage
                : Double.compare(b.failure, a.failure)
        );

        int[] answer = new int[N];
        for (int i = 0; i < failures.length; i++) {
            answer[i] = failures[i].stage;
        }
        return answer;
    }

    public class Failure {
        int stage;
        double failure;

        public Failure(int stage, double failure) {
            this.stage = stage;
            this.failure = failure;
        }
    }
}
/*
테스트 1 〉	통과 (0.70ms, 75.9MB)
테스트 2 〉	통과 (0.76ms, 74.7MB)
테스트 3 〉	통과 (1.61ms, 85MB)
테스트 4 〉	통과 (3.19ms, 87.2MB)
테스트 5 〉	통과 (4.72ms, 99.8MB)
테스트 6 〉	통과 (1.07ms, 76.3MB)
테스트 7 〉	통과 (1.56ms, 78MB)
테스트 8 〉	통과 (3.31ms, 87.2MB)
테스트 9 〉	통과 (4.35ms, 84.7MB)
테스트 10 〉	통과 (3.25ms, 89.4MB)
테스트 11 〉	통과 (3.19ms, 78.9MB)
테스트 12 〉	통과 (3.20ms, 89.1MB)
테스트 13 〉	통과 (3.30ms, 89.9MB)
테스트 14 〉	통과 (0.76ms, 74.4MB)
테스트 15 〉	통과 (1.94ms, 85.5MB)
테스트 16 〉	통과 (1.26ms, 72.9MB)
테스트 17 〉	통과 (1.91ms, 83MB)
테스트 18 〉	통과 (1.25ms, 78.4MB)
테스트 19 〉	통과 (0.79ms, 81.7MB)
테스트 20 〉	통과 (1.61ms, 86.4MB)
테스트 21 〉	통과 (2.28ms, 92.9MB)
테스트 22 〉	통과 (5.25ms, 94.2MB)
테스트 23 〉	통과 (3.26ms, 82.3MB)
테스트 24 〉	통과 (3.15ms, 87.1MB)
테스트 25 〉	통과 (0.64ms, 77.9MB)
테스트 26 〉	통과 (0.64ms, 72.4MB)
테스트 27 〉	통과 (0.78ms, 74.7MB)
 */
