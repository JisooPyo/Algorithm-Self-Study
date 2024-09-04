package bookStudy.study2409;

/**
 * 프로그래머스 lv.2
 * 26. 예상대진표
 */
public class Problem26 {
    public static void main(String[] args) {
        Problem26 p = new Problem26();
        System.out.println(p.solution(8, 4, 7));    // 3
    }

    // 시간 복잡도: O(log N)
    public int solution(int n, int a, int b) {
        int answer = 1;
        int divisor = 2;
        while (((a - 1) / divisor) != ((b - 1) / divisor)) {
            divisor *= 2;
            answer++;
        }
        return answer;
    }
}

/*
테스트 1 〉	통과 (0.01ms, 69.8MB)
테스트 2 〉	통과 (0.02ms, 75MB)
테스트 3 〉	통과 (0.04ms, 70.9MB)
테스트 4 〉	통과 (0.02ms, 77.2MB)
테스트 5 〉	통과 (0.02ms, 73.8MB)
테스트 6 〉	통과 (0.02ms, 79.7MB)
테스트 7 〉	통과 (0.03ms, 80MB)
테스트 8 〉	통과 (0.03ms, 74.2MB)
테스트 9 〉	통과 (0.01ms, 77.6MB)
테스트 10 〉	통과 (0.03ms, 66.1MB)
테스트 11 〉	통과 (0.03ms, 74MB)
테스트 12 〉	통과 (0.02ms, 87.5MB)
테스트 13 〉	통과 (0.03ms, 73.3MB)
테스트 14 〉	통과 (0.01ms, 72.3MB)
테스트 15 〉	통과 (0.02ms, 77.1MB)
테스트 16 〉	통과 (0.02ms, 76.1MB)
테스트 17 〉	통과 (0.01ms, 77.5MB)
테스트 18 〉	통과 (0.02ms, 71.3MB)
테스트 19 〉	통과 (0.02ms, 74.2MB)
테스트 20 〉	통과 (0.02ms, 71.5MB)
테스트 21 〉	통과 (0.03ms, 79.9MB)
테스트 22 〉	통과 (0.04ms, 78.9MB)
테스트 23 〉	통과 (0.04ms, 82.2MB)
테스트 24 〉	통과 (0.02ms, 73.9MB)
테스트 25 〉	통과 (0.02ms, 78.4MB)
테스트 26 〉	통과 (0.02ms, 72MB)
테스트 27 〉	통과 (0.01ms, 72.1MB)
테스트 28 〉	통과 (0.03ms, 69.4MB)
테스트 29 〉	통과 (0.02ms, 80.4MB)
테스트 30 〉	통과 (0.01ms, 86.7MB)
테스트 31 〉	통과 (0.02ms, 71.3MB)
테스트 32 〉	통과 (0.02ms, 74.3MB)
테스트 33 〉	통과 (0.02ms, 76.1MB)
테스트 34 〉	통과 (0.03ms, 68.2MB)
 */
