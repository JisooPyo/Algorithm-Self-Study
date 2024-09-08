package programmers.test2409;

import java.util.Arrays;

/**
 * 프로그래머스 lv.2
 * 소수 찾기
 */
public class P42839 {
    public static void main(String[] args) {
        P42839 p = new P42839();
        System.out.println(p.solution("17"));       // 3
        System.out.println(p.solution("011"));      // 2
    }

    public int solution(String numbers) {
        // 1. 최소, 최대 구하기
        char[] chars = numbers.toCharArray();
        Arrays.sort(chars);
        int min = chars[0] - '0';
        int max = Integer.valueOf(new StringBuilder(new String(chars)).reverse().toString());

        // 2. 에라토스테네스의 체로 소수 구하기
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * 2 <= max; i++) {
            if (!isPrime[i]) {
                continue;
            }
            int index = i * 2;
            while (index <= max) {
                if (isPrime[index]) {
                    isPrime[index] = false;
                }
                index += i;
            }
        }

        // numbers 숫자 카드 카운트 하기
        int[] count = new int[10];
        for (int i = 0; i < numbers.length(); i++) {
            count[numbers.charAt(i) - '0']++;
        }

        int answer = 0;
        for (int i = min; i <= max; i++) {
            if (isPrime[i] && canMake(i, count)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean canMake(int i, int[] count) {
        int[] copy = Arrays.copyOf(count, count.length);
        while (i > 0) {
            copy[i % 10]--;
            if (copy[i % 10] < 0) {
                return false;
            }
            i /= 10;
        }
        return true;
    }
}
/*
테스트 1 〉	통과 (0.80ms, 76.7MB)
테스트 2 〉	통과 (21.12ms, 83.8MB)
테스트 3 〉	통과 (0.37ms, 74.5MB)
테스트 4 〉	통과 (16.12ms, 83.1MB)
테스트 5 〉	통과 (65.45ms, 104MB)
테스트 6 〉	통과 (0.54ms, 74.2MB)
테스트 7 〉	통과 (0.78ms, 77.5MB)
테스트 8 〉	통과 (93.82ms, 117MB)
테스트 9 〉	통과 (0.43ms, 77.5MB)
테스트 10 〉	통과 (31.93ms, 81.7MB)
테스트 11 〉	통과 (6.51ms, 79.1MB)
테스트 12 〉	통과 (4.93ms, 80.6MB)
 */
