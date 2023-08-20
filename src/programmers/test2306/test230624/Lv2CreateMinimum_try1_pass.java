package programmers.test2306.test230624;

import java.util.Arrays;

public class Lv2CreateMinimum_try1_pass {
    public static void main(String[] args) {
        Lv2CreateMinimum_try1_pass lv = new Lv2CreateMinimum_try1_pass();

        int[] t1_1 = {1, 4, 2};
        int[] t1_2 = {5, 4, 4};

        int[] t2_1 = {1, 2};
        int[] t2_2 = {3, 4};

        System.out.println(lv.solution(t1_1, t1_2));
        System.out.println(lv.solution(t2_1, t2_2));
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - 1 - i];
        }
        return answer;
    }

}
/*
정확성  테스트
테스트 1 〉통과 (0.57ms, 70.2MB)
테스트 2 〉통과 (0.54ms, 80.5MB)
테스트 3 〉통과 (0.61ms, 81.2MB)
테스트 4 〉통과 (0.45ms, 72.2MB)
테스트 5 〉통과 (0.56ms, 78.7MB)
테스트 6 〉통과 (0.60ms, 75.1MB)
테스트 7 〉통과 (0.58ms, 73MB)
테스트 8 〉통과 (0.52ms, 76.2MB)
테스트 9 〉통과 (0.41ms, 72.4MB)
테스트 10 〉통과 (0.57ms, 80.1MB)
테스트 11 〉통과 (0.51ms, 66.8MB)
테스트 12 〉통과 (0.57ms, 73.9MB)
테스트 13 〉통과 (0.51ms, 77.2MB)
테스트 14 〉통과 (0.54ms, 77.5MB)
테스트 15 〉통과 (0.58ms, 68MB)
테스트 16 〉통과 (0.45ms, 77.5MB)

효율성  테스트
테스트 1 〉통과 (1.61ms, 52.6MB)
테스트 2 〉통과 (1.33ms, 52.2MB)
테스트 3 〉통과 (2.20ms, 52.7MB)
테스트 4 〉통과 (2.31ms, 52.2MB)
 */